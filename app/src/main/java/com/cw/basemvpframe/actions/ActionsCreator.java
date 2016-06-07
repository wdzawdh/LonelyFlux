package com.cw.basemvpframe.actions;


import com.cw.basemvpframe.dispatcher.Dispatcher;
import com.cw.basemvpframe.model.ZhuangbiImage;
import com.cw.basemvpframe.network.Network;
import com.cw.basemvpframe.stores.Store;

import java.util.List;

import rx.Observer;
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


    public static void actionDectory(){
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
                .subscribe(new Observer<List<ZhuangbiImage>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<ZhuangbiImage> zhuangbiImages) {
                        dispatcher.dispatch(new ZhuangbiAction(ZhuangbiAction.ACTION_ZHANGBI_DATA, zhuangbiImages));
                    }
                });
    }

    public void sendZhuangbiData(List<ZhuangbiImage> zhuangbiImages) {
        dispatcher.dispatch(new ZhuangbiAction(ZhuangbiAction.ACTION_ZHANGBI_DATA, zhuangbiImages));
    }

    public void sendGankBeauty(int page){
        subscription = Network.getGankApi()
                .getBeauties(10, page)
                .map(gankBeautyResult -> !gankBeautyResult.error?gankBeautyResult.results:null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ZhuangbiImage>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<ZhuangbiImage> zhuangbiImages) {
                        dispatcher.dispatch(new GankBeautyAction(GankBeautyAction.ACTION_BEAUTY_DATA,zhuangbiImages));
                    }
                });

    }

}
