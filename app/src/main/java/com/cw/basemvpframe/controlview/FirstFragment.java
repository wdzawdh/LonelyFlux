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

package com.cw.basemvpframe.controlview;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cw.basemvpframe.R;
import com.cw.basemvpframe.base.BaseFragment;

import butterknife.Bind;

/**
 * 给Fragment添加newInstance方法，将需要的参数传入，设置到bundle中，然后setArguments(bundle)，最后在onCreate中进行获取。
 * 调用者只需要关系传递的哪些数据，而无需关心传递数据的Key是什么。
 * @author Cw
 * @date 16/5/30
 */
public class FirstFragment extends BaseFragment {

    public static String FIRST_FRAGMENT = "first_fragment";

    private String msg;

    @Bind(R.id.username_edt)
    TextView tvUsername;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_first;
    }

    public static FirstFragment newInstance(String msg) {
        FirstFragment fragment = new FirstFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(FIRST_FRAGMENT, msg);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null != getArguments()) {
            msg = (String) getArguments().getSerializable(FIRST_FRAGMENT);
        }
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        tvUsername = (TextView) view.findViewById(R.id.username_edt);
        tvUsername.setText(msg);
    }

}
