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

package com.cw.basemvpframe.controlview.fours;

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
public class FoursFragment extends BaseFragment {

    private static FoursFragment foursFragment;

    public static BaseFragment getInstance() {
        if(foursFragment==null){
            foursFragment = new FoursFragment();
        }
        return foursFragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_fours;
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