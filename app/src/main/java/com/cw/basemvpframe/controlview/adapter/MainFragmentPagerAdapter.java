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

package com.cw.basemvpframe.controlview.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cw.basemvpframe.controlview.MainActivity;
import com.cw.basemvpframe.controlview.first.FirstFragment;
import com.cw.basemvpframe.controlview.fours.FoursFragment;
import com.cw.basemvpframe.controlview.second.SecondFragment;
import com.cw.basemvpframe.controlview.third.ThirdFragment;

/**
 *
 * @author Cw
 * @date 16/6/3
 */
public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

    public MainFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return MainActivity.MAIN_PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FirstFragment.newInstance("模拟参数");
            case 1:
                return SecondFragment.newInstance();
            case 2:
                return ThirdFragment.newInstance();
            case 3:
                return FoursFragment.newInstance();
            default:
                return FirstFragment.newInstance("模拟参数");
        }

    }
}