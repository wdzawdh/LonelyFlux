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

package com.cw.basemvpframe.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cw.basemvpframe.R;
import com.cw.basemvpframe.base.BaseFragment;
import com.cw.basemvpframe.utils.ToastUtils;

/**
 *
 * @author Cw
 * @date 16/5/30
 */
public class MainFragment extends BaseFragment {

    private Button mainBtn,mainSecondBtn;

    public static MainFragment newInstance() {
        return new MainFragment();
    }


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mainBtn = (Button) view.findViewById(R.id.main_btn);
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(FirstFragment.newInstance("username"));
                ToastUtils.showMessage(getContext(),"FirstFragment");

            }
        });

        mainSecondBtn = (Button) view.findViewById(R.id.main_second_btn);
        mainSecondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(SecondFragment.newInstance());
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }
}