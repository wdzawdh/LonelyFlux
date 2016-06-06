package com.cw.basemvpframe.actions;


import com.cw.basemvpframe.dispatcher.Dispatcher;
import com.cw.basemvpframe.model.ZhuangbiImage;
import com.cw.basemvpframe.network.Network;
import com.cw.basemvpframe.stores.Store;

import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Flux的ActionCreator模块
 */
public class ActionsCreator {

    private static Subscription subscription;
    private static Dispatcher dispatcher;
    private static ActionsCreator actionsCreator;

    private ActionsCreator(Dispatcher dispatcher) {
        ActionsCreator.dispatcher = dispatcher;
    }

    public static ActionsCreator newInstance(Store store){
        if(actionsCreator==null){
            actionsCreator = new ActionsCreator(Dispatcher.newInstance());
        }
        dispatcher.register(store);
        return actionsCreator;
    }


    public static void ActionDectory(){
        if(subscription!=null){
            subscription.unsubscribe();
        }
    }

    public void sendMainMessage(int message) {
        dispatcher.dispatch(new MainAction(MainAction.ACTION_CHANGE_FRAGMENT, message));
    }

    public void sendZhuangbiData() {
        subscription = Network.getZhuangbiApi()
                .search("装逼")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::sendZhuangbiData);
    }

    public void sendZhuangbiData(List<ZhuangbiImage> zhuangbiImages) {
        dispatcher.dispatch(new ZhuangbiAction(ZhuangbiAction.ACTION_ZHANGBI_DATA, zhuangbiImages));
    }

}
