package com.cw.basemvpframe.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.cw.basemvpframe.R;
import com.cw.basemvpframe.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private final int MAIN_PAGE_COUNT = 4;

    @Bind(R.id.fl_title_main)
    FrameLayout titleMain;
    @Bind(R.id.vp_content_main)
    ViewPager contentMain;
    @Bind(R.id.fl_foot_main)
    FrameLayout footMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initTitle();
        initFoot();
        initView();
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
        contentMain.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return MAIN_PAGE_COUNT;
            }

            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return FirstFragment.newInstance("模拟参数");
                    case 1:
                        return SecondFragment.newInstance();
                    case 2:
                        return ThirdFragment.newInstance();
                    case 3:
                        return FoursFragment.newInstance();
                    default:
                        return FirstFragment.newInstance("模拟参数");
                }

            }
        });
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.ll_main;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_1:
                //设置ViewPager到指定的页面
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
}
