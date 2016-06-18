package com.cw.basemvpframe.dispatcher;


import com.cw.basemvpframe.base.Action;
import com.cw.basemvpframe.stores.Store;

import java.util.ArrayList;
import java.util.List;

;

/**
 * Flux的Dispatcher模块
 */
public class Dispatcher {
    private static Dispatcher instance;
    private final List<Store> stores = new ArrayList<>();

    private Dispatcher() {
    }

    public static Dispatcher newInstance() {
        if (instance == null) {
            instance = new Dispatcher();
        }
        return instance;
    }

    public void register(final Store store) {
        if (store == null) {
            return;
        }
        if (!stores.contains(store)) {
            stores.add(store);
        }
    }

    public void unregister(final Store store) {
        stores.remove(store);
    }

    public void dispatch(Action action) {
        post(action);
    }

    private void post(final Action action) {
        for (Store store : stores) {
            store.onAction(action);
        }
    }
}
