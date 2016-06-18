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
                return FirstFragment.getInstance();
            case 1:
                return SecondFragment.getInstance();
            case 2:
                return ThirdFragment.getInstance();
            case 3:
                return FoursFragment.getInstance();
            default:
                return FirstFragment.getInstance();
        }

    }
}