package com.cw.basemvpframe.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;

import com.cw.basemvpframe.R;
import com.cw.basemvpframe.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

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
}
