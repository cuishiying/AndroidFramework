package com.irelint.framework.base;

import android.app.Application;
import android.content.Context;

/**
 * 作者：当我遇上你 on 2016-12-20 00:48
 * 邮箱：cuishiying163@163.com
 */

public class BaseApplication extends Application{
    private static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this;
    }
    public static Context getAppContext() {
        return applicationContext;
    }
}
