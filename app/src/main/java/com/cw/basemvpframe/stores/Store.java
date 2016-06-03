package com.cw.basemvpframe.stores;

import com.cw.basemvpframe.actions.Action;
import com.squareup.otto.Bus;

/**
 * Flux的Store模块
 */
public abstract class Store {
    private  static final Bus bus = new Bus();

    protected Store() {
    }

    public void register(final Object view) {
        bus.register(view);
    }

    public void unregister(final Object view) {
        bus.unregister(view);
    }

    void emitStoreChange(Object event) {
        bus.post(event);
    }

    public abstract void onAction(Action action);

}
