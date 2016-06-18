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

package com.cw.basemvpframe.controlview.second;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cw.basemvpframe.R;
import com.cw.basemvpframe.base.BaseFragment;
import com.cw.basemvpframe.controlview.adapter.GankBeautyListAdapter;
import com.cw.basemvpframe.stores.SecondStore;
import com.cw.basemvpframe.stores.Store;
import com.squareup.otto.Subscribe;

import butterknife.Bind;
import rx.Subscription;

/**
 *
 * @author Cw
 * @date 16/5/30
 */
public class SecondFragment extends BaseFragment {

    @Bind(R.id.rv_content)
    RecyclerView rvContent;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout refreshLayout;

    private GankBeautyListAdapter adapter = new GankBeautyListAdapter();
    private SecondStore secondStore;
    private int page;
    private static SecondFragment secondFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_second;
    }

    public static BaseFragment getInstance() {
        if(secondFragment==null){
            secondFragment = new SecondFragment();
        }
        return secondFragment;
    }

    @Override
    protected Store createStore() {
        secondStore = new SecondStore();
        return secondStore;
    }

    @Override
    public Subscription dispatcherAction() {
        return actionsCreator.sendGankBeauty(++page);
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
    }

    @Subscribe
    public void onLoadPageData(SecondStore.BeautyDataEvent event) {
        adapter.setImages(secondStore.getGankBeautyList());
        rvContent.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvContent.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        secondStore.register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        secondStore.unregister(this);
    }

}