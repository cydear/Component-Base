package com.basic.component_base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class ComponentApplication extends Application {
    private final String TAG = ComponentApplication.class.getSimpleName();
    private static Context mApp;

    /**
     * 创建应用程序时回调
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "ComponentApplication===>onCreate");
        mApp = this;
        registerActivityListener();
    }

    public static Context getApp() {
        return mApp;
    }

    /**
     * 注册Activity生命周期的监听
     */
    private void registerActivityListener() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Log.d(TAG, "ComponentApplication===>onActivityCreated");
            }

            @Override
            public void onActivityStarted(Activity activity) {
                Log.d(TAG, "ComponentApplication===>onActivityStarted");
            }

            @Override
            public void onActivityResumed(Activity activity) {
                Log.d(TAG, "ComponentApplication===>onActivityResumed");
            }

            @Override
            public void onActivityPaused(Activity activity) {
                Log.d(TAG, "ComponentApplication===>onActivityPaused");
            }

            @Override
            public void onActivityStopped(Activity activity) {
                Log.d(TAG, "ComponentApplication===>onActivityStopped");
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                Log.d(TAG, "ComponentApplication===>onActivitySaveInstanceState");
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                Log.d(TAG, "ComponentApplication===>onActivityDestroyed");
            }
        });
    }

    /**
     * 后台应用程序终止且资源还匮乏时会调用这个方法
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.d(TAG, "ComponentApplication===>onLowMemory");
    }

    /**
     * 当终止应用程序时调用，不保证一定会被调用，当程序被内核终止一遍其他用用程序四方资源时将不会提醒，
     * 并且不调用应用程序对象的onTerminate方法而直接终止进程
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(TAG, "ComponentApplication===>onTerminate");
    }

    /**
     * 配置改变时触发方法
     *
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "ComponentApplication===>onConfigurationChanged");
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Log.d(TAG, "ComponentApplication===>attachBaseContext");
    }
}
