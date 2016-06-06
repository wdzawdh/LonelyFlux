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

package com.cw.basemvpframe.actions;

import com.cw.basemvpframe.base.Action;
import com.cw.basemvpframe.model.ZhuangbiImage;

import java.util.List;

/**
 *
 * @author Cw
 * @date 16/6/6
 */
public class ZhuangbiAction extends Action<List<ZhuangbiImage>> {

    public static final String ACTION_ZHANGBI_DATA = "action_zhangbi_data";

    ZhuangbiAction(String type, List<ZhuangbiImage> data) {
        super(type, data);
    }
}