package com.cw.basemvpframe.actions;


import com.cw.basemvpframe.base.Action;

public class MainAction extends Action<Integer> {
    public static final String ACTION_CHANGE_FRAGMENT = "change_fragment";

    MainAction(String type, int data) {
        super(type, data);
    }
}
