package com.cw.basemvpframe.stores;


import com.cw.basemvpframe.actions.Action;
import com.cw.basemvpframe.actions.MainAction;
import com.cw.basemvpframe.model.MainMessage;
import com.squareup.otto.Subscribe;

/**
 * MessageStore类主要用来维护MainActivity的UI状态
 */
public class MainStore extends Store {
    private static MainStore singleton;
    private MainMessage mMessage = new MainMessage();

    public MainStore() {
        super();
    }

    public int getMessage() {
        return mMessage.getMessage();
    }

    @Override
    @Subscribe
    public void onAction(Action action) {
        switch (action.getType()) {
            case MainAction.ACTION_CHANGE_FRAGMENT:
                mMessage.setMessage((Integer) action.getData());
                emitStoreChange(new MainFragmentEvent());
                break;
            default:
        }
    }

    public static class MainFragmentEvent{}

}
