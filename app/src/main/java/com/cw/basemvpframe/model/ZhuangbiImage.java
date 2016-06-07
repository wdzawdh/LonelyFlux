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

package com.cw.basemvpframe.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Cw
 * @date 16/6/6
 */
public class ZhuangbiImage {
    private @SerializedName(value = "image_url", alternate = {"url"})
    String image_url;

    private @SerializedName(value = "description", alternate = {"createdAt"})
    String description;

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}