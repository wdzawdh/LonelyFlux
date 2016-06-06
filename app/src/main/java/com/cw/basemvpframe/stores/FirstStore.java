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

import com.cw.basemvpframe.actions.ZhuangbiAction;
import com.cw.basemvpframe.base.Action;
import com.cw.basemvpframe.model.ZhuangbiImage;
import com.squareup.otto.Subscribe;

import java.util.List;

/**
 * @author Cw
 * @date 16/6/6
 */
public class FirstStore extends Store {

    private List<ZhuangbiImage> zhuangbiImages;

    public List<ZhuangbiImage> getZhuangbiImage() {
        return zhuangbiImages;
    }

    @Override
    @Subscribe
    public void onAction(Action action) {
        switch (action.getType()) {
            case ZhuangbiAction.ACTION_ZHANGBI_DATA:
                ZhuangbiAction zhuangbiAction = (ZhuangbiAction) action;
                zhuangbiImages = zhuangbiAction.getData();
                emitStoreChange(new ZhuangbiDataEvent());
                break;
            default:
        }
    }

    public static class ZhuangbiDataEvent {}
}