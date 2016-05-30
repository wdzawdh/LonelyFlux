package com.cw.basemvpframe.view;

import com.cw.basemvpframe.base.BaseAppActivity;
import com.cw.basemvpframe.base.BaseFragment;

public class MainActivity extends BaseAppActivity {

    @Override
    protected BaseFragment getFirstFragment() {
        return MainFragment.newInstance();
    }
}
