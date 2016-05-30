/**
 *
 *   @function:$
 *   @description: $
 *   @param:$
 *   @return:$
 *   @history:
 * 1.date:$ $
 *           author:$
 *           modification:
 */

package com.cw.basemvpframe.base;

/**
 *
 * @author Cw
 * @date 16/5/30
 */

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;

import com.cw.basemvpframe.view.MainActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class BaseApplication extends Application implements Thread.UncaughtExceptionHandler {

    //全局的上下文
    private static Context mContext;
    //全局的handler
    private static Handler mHandler;
    //主线程
    private static Thread mMainThread;
    //主线程id
    private static int mMainThreadId;

    public static Context getContext() {
        return mContext;
    }
    public static Handler getHandler() {
        return mHandler;
    }
    public static Thread getMainThread() {
        return mMainThread;
    }
    public static int getMainThreadId() {
        return mMainThreadId;
    }

    @Override
    public void onCreate() {
        mContext=getApplicationContext();
        mHandler=new Handler();
        //application运行在主线程中
        mMainThread=Thread.currentThread();
        //获取当前线程的id
        mMainThreadId=android.os.Process.myTid();
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        //等待处理，长时间不处理，就会出现ANR
        //收集日志，保存到sdcard,收集当前设备的参数信息
        try {
            ex.printStackTrace(new PrintStream(new File(Environment.getExternalStorageDirectory(),"log.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //TODO 有移动网或wifi的时候上传日志

        //3.杀死应用程序,或重启
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        //杀死自己
        android.os.Process.killProcess(android.os.Process.myPid());


    }
}