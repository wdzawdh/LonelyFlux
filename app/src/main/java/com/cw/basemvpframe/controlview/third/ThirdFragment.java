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
import com.cw.basemvpframe.stores.Store;

import rx.Subscription;

/**
 *
 * @author Cw
 * @date 16/5/30
 */
public class ThirdFragment extends BaseFragment {

    private static ThirdFragment thirdFragment;

    public static BaseFragment getInstance() {
        if(thirdFragment==null){
            thirdFragment = new ThirdFragment();
        }
        return thirdFragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_third;
    }

    @Override
    protected Subscription dispatcherAction() {
        return null;
    }

    @Override
    protected Store createStore() {
        return null;
    }



}