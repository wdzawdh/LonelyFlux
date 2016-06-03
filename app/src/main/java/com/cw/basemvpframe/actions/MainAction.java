package com.cw.basemvpframe.actions;


public class MainAction extends Action<Integer> {
    public static final String ACTION_CHANGE_FRAGMENT = "change_fragment";

    MainAction(String type, int data) {
        super(type, data);
    }
}
