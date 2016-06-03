package com.cw.basemvpframe.controlview;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.cw.basemvpframe.R;
import com.cw.basemvpframe.actions.ActionsCreator;
import com.cw.basemvpframe.base.BaseActivity;
import com.cw.basemvpframe.controlview.adapter.MainFragmentPagerAdapter;
import com.cw.basemvpframe.dispatcher.Dispatcher;
import com.cw.basemvpframe.stores.MainStore;
import com.squareup.otto.Subscribe;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    public static final int MAIN_PAGE_COUNT = 4;

    @Bind(R.id.fl_title_main) FrameLayout titleMain;
    @Bind(R.id.vp_content_main) ViewPager contentMain;
    @Bind(R.id.fl_foot_main) FrameLayout footMain;

    private ActionsCreator actionsCreator;
    private MainStore store;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initDependencies();
        initTitle();
        initFoot();
        initView();
    }

    private void initDependencies() {
        Dispatcher dispatcher = Dispatcher.get();
        actionsCreator = ActionsCreator.get(dispatcher);
        store = new MainStore();
        dispatcher.register(store);
    }

    private void initTitle() {
        //add title
        View titleView = View.inflate(getApplicationContext(), R.layout.title_main, null);
        titleMain.addView(titleView);
    }

    private void initFoot() {
        //add foot
        View footView = View.inflate(getApplicationContext(), R.layout.foot_main, null);
        RadioGroup rgTabBar = (RadioGroup) footView.findViewById(R.id.rg_tab_bar);
        rgTabBar.setOnCheckedChangeListener(this);
        footMain.addView(footView);
    }

    private void initView() {
        //add content
        contentMain.setAdapter(new MainFragmentPagerAdapter(getSupportFragmentManager()));
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.ll_main;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        actionsCreator.sendMainMessage(checkedId);
    }

    @Subscribe
    public void onFragmentChange(MainStore.MainFragmentEvent event) {
        fragmentChange(store);
    }



    /**
     * 设置ViewPager到指定的页面
     */
    private void fragmentChange(MainStore store) {

        switch (store.getMessage()) {
            case R.id.rb_1:
                //第二个参数代表是否需要切换时滑动的视觉效果
                contentMain.setCurrentItem(0, false);
                break;
            case R.id.rb_2:
                contentMain.setCurrentItem(1, false);
                break;
            case R.id.rb_3:
                contentMain.setCurrentItem(2, false);
                break;
            case R.id.rb_4:
                contentMain.setCurrentItem(3, false);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        store.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        store.unregister(this);
    }
}
