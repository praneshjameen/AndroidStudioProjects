package com.example.zeolite.social;

/**
 * Created by 1jpra on 2/22/2018.
 */

public class ImageUpload {
    public String name,pushKey,caption,tim,regNo;
    public String uri;

    public String getPushKey() {
        return pushKey;
    }

    public String getCaption() {
        return caption;
    }

    public String getTim() {
        return tim;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getName() {
        return name;
    }

    public String getUri() {
        return uri;
    }

    public ImageUpload(String name, String pushKey, String caption, String tim, String regNo, String uri) {
        this.name = name;
        this.pushKey = pushKey;
        this.caption = caption;
        this.tim = tim;
        this.regNo = regNo;
        this.uri = uri;
    }

    public ImageUpload(){}
}
