package com.cw.basemvpframe.actions;


import android.support.annotation.NonNull;

import com.cw.basemvpframe.dispatcher.Dispatcher;
import com.cw.basemvpframe.network.Network;
import com.cw.basemvpframe.stores.Store;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Flux的ActionCreator模块
 */
public class ActionsCreator {

    private static Dispatcher dispatcher;
    private static ActionsCreator actionsCreator;

    private ActionsCreator(Dispatcher dispatcher) {
        ActionsCreator.dispatcher = dispatcher;
    }

    public static ActionsCreator newInstance(@NonNull Store store){
        if(actionsCreator==null){
            actionsCreator = new ActionsCreator(Dispatcher.newInstance());
        }
        dispatcher.register(store);
        return actionsCreator;
    }


    public static void actionDectory(Subscription subscription){
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    public void sendMainMessage(int message) {
        dispatcher.dispatch(new MainAction(MainAction.ACTION_CHANGE_FRAGMENT, message));
    }

    public Subscription sendZhuangbiData() {
        return Network.getZhuangbiApi()
                .search("装逼")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(zhuangbiImages -> {
                    dispatcher.dispatch(new ZhuangbiAction(ZhuangbiAction.ACTION_ZHANGBI_DATA, zhuangbiImages));
                });
    }

    public Subscription sendGankBeauty(int page){
        return Network.getGankApi()
                .getBeauties(10, page)
                .map(gankBeautyResult -> !gankBeautyResult.error?gankBeautyResult.results:null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(gankBeauties -> {
                    dispatcher.dispatch(new GankBeautyAction(GankBeautyAction.ACTION_BEAUTY_DATA,gankBeauties));
                });

    }

}
