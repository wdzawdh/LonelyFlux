package com.cw.basemvpframe.model;


public class MainMessage {
    private int mText;

    public MainMessage(){}

    public MainMessage(int text) {
        mText = text;
    }

    public int getMessage() {
        return mText;
    }

    public void setMessage(int text) {
        mText = text;
    }
}
