/**
 *   @function:$
 *   @description: $
 *   @param:$
 *   @return:$
 *   @history:
 * 1.date:$ $
 *           author:$
 *           modification:
 */

package com.cw.basemvpframe.controlview.first;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cw.basemvpframe.R;
import com.cw.basemvpframe.actions.ActionsCreator;
import com.cw.basemvpframe.base.BaseFragment;
import com.cw.basemvpframe.model.ZhuangbiImage;
import com.cw.basemvpframe.stores.FirstStore;
import com.squareup.otto.Subscribe;

import java.util.List;

/**
 * 给Fragment添加newInstance方法，将需要的参数传入，设置到bundle中，然后setArguments(bundle)，最后在onCreate中进行获取。
 * 调用者只需要关系传递的哪些数据，而无需关心传递数据的Key是什么。
 *
 * @author Cw
 * @date 16/5/30
 */
public class FirstFragment extends BaseFragment {


    private ActionsCreator actionsCreator;
    private FirstStore firstStore;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_first;
    }

    public static FirstFragment newInstance() {
        return new FirstFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDependencies();
    }

    private void initDependencies() {
        firstStore = new FirstStore();
        actionsCreator = ActionsCreator.newInstance(firstStore);
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        actionsCreator.sendZhuangbiData();
    }

    @Subscribe
    public void onLoadPageData(FirstStore.ZhuangbiDataEvent event) {
        List<ZhuangbiImage> zhuangbiImages = firstStore.getZhuangbiImage();
        Log.d("cw",zhuangbiImages.get(0).getDescription());
    }

    @Override
    public void onResume() {
        super.onResume();
        firstStore.register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        firstStore.unregister(this);
    }
}
