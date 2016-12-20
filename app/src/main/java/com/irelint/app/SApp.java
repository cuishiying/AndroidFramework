package com.irelint.app;

import com.irelint.framework.base.BaseApplication;
import com.irelint.framework.http.Request;

/**
 * 作者：当我遇上你 on 2016-12-20 18:38
 * 邮箱：cuishiying163@163.com
 */

public class SApp extends BaseApplication{
    public static NewsService mService;
    @Override
    public void onCreate() {
        super.onCreate();
        Request request = new Request();
        mService = request.init("http://124.133.20.170/api/", NewsService.class);
    }
}
