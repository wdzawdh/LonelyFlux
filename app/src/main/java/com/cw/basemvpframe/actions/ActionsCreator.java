package com.cw.basemvpframe.actions;


import com.cw.basemvpframe.dispatcher.Dispatcher;

/**
 * Flux的ActionCreator模块
 */
public class ActionsCreator {

    private static ActionsCreator instance;
    final Dispatcher dispatcher;

    ActionsCreator(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public static ActionsCreator get(Dispatcher dispatcher) {
        if (instance == null) {
            instance = new ActionsCreator(dispatcher);
        }
        return instance;
    }

    public void sendMessage(int message) {
        dispatcher.dispatch(new MainAction(MainAction.ACTION_CHANGE_FRAGMENT, message));
    }
}
