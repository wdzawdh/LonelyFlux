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
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cw.basemvpframe.R;
import com.cw.basemvpframe.actions.ActionsCreator;
import com.cw.basemvpframe.base.BaseFragment;
import com.cw.basemvpframe.controlview.adapter.ZhuangbiListAdapter;
import com.cw.basemvpframe.stores.SecondStore;
import com.squareup.otto.Subscribe;

import butterknife.Bind;

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

    private ZhuangbiListAdapter adapter = new ZhuangbiListAdapter();
    private ActionsCreator actionsCreator;
    private SecondStore secondStore;
    private int page;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_second;
    }

    public static SecondFragment newInstance() {
        return new SecondFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDependencies();
    }

    private void initDependencies() {
        secondStore = new SecondStore();
        actionsCreator = ActionsCreator.newInstance(secondStore);
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        actionsCreator.sendGankBeauty(++page);
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