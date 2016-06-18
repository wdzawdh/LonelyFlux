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

package com.cw.basemvpframe.stores;

import com.cw.basemvpframe.actions.GankBeautyAction;
import com.cw.basemvpframe.base.Action;
import com.cw.basemvpframe.model.GankBeauty;
import com.squareup.otto.Subscribe;

import java.util.List;

/**
 * @author Cw
 * @date 16/6/7
 */
public class SecondStore extends Store {

    private List<GankBeauty> gankBeautyList;

    public List<GankBeauty> getGankBeautyList() {
        return gankBeautyList;
    }

    @Override
    @Subscribe
    public void onAction(Action action) {
        switch (action.getType()) {
            case GankBeautyAction.ACTION_BEAUTY_DATA:
                GankBeautyAction gankBeautyAction = (GankBeautyAction) action;
                gankBeautyList = gankBeautyAction.getData();
                emitStoreChange(new BeautyDataEvent());
                break;
            default:
        }
    }

    public static class BeautyDataEvent {}
}