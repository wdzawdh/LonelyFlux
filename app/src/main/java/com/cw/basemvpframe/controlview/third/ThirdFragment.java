/**
 *
 *   @function:$
 *   @description: $
 *   @param:$
 *   @return:$
 *   @history:
 * 1.date:$ $
 *           author:$
 *           modification:
 */

package com.cw.basemvpframe.controlview.third;

import android.os.Bundle;
import android.view.View;

import com.cw.basemvpframe.R;
import com.cw.basemvpframe.base.BaseFragment;

/**
 *
 * @author Cw
 * @date 16/5/30
 */
public class ThirdFragment extends BaseFragment {

    public static ThirdFragment newInstance() {
        return new ThirdFragment();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_third;
    }
}