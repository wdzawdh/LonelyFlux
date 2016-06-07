// (c)2016 Flipboard Inc, All Rights Reserved.

package com.cw.basemvpframe.model;

import com.google.gson.annotations.SerializedName;

public class GankBeauty {
    private @SerializedName("url") String image_url;

    private @SerializedName("createdAt") String description;

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
