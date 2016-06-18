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

package com.cw.basemvpframe.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cw.basemvpframe.actions.ActionsCreator;
import com.cw.basemvpframe.stores.Store;

import butterknife.ButterKnife;
import rx.Subscription;

/**
 *
 * @author Cw
 * @date 16/5/30
 */
public abstract class BaseFragment extends Fragment {

    protected BaseActivity mActivity;
    private View mRootView;
    private Subscription subscription;
    protected ActionsCreator actionsCreator;

    //初始化View
    protected abstract void initView(View view, Bundle savedInstanceState);
    //获取布局文件ID
    protected abstract int getLayoutId();
    //发送Action
    protected abstract Subscription dispatcherAction();
    //创建Store
    protected abstract Store createStore();

    //获取宿主Activity
    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (BaseActivity) activity;
    }

    //添加fragment
    protected void addFragment(BaseFragment fragment) {
        if (null != fragment) {
            getHoldingActivity().addFragment(fragment);
        }
    }

    //移除fragment
    protected void removeFragment() {
        getHoldingActivity().removeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Store store = createStore();
        actionsCreator = ActionsCreator.newInstance(store);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this,mRootView);
        subscription = dispatcherAction();
        initView(mRootView, savedInstanceState);
        return mRootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(mRootView);
        ActionsCreator.actionDectory(subscription);
    }

}