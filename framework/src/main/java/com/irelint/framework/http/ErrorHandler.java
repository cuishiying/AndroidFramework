package com.irelint.framework.http;

import com.blankj.utilcode.utils.LogUtils;
import com.irelint.framework.utils.GsonTools;

import org.json.JSONException;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;

/**
 * 作者：当我遇上你 on 2016-12-20 01:20
 * 邮箱：cuishiying163@163.com
 * 错误处理
 */

public class ErrorHandler {
    public static Error handle(Throwable throwable) {
        if (throwable instanceof HttpException) {
            //网络异常
            HttpException error = (HttpException) throwable;
            try {
                Error e = GsonTools.getInstance().changeGsonToBean(error.response().errorBody().string(), Error.class);
                e.code = error.response().code();//根据不同的错误码进行处理,502网关异常,400权限异常，404,500
                return e;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(throwable instanceof JSONException){
            //Json解析异常
            LogUtils.e("Json解析异常"+throwable.toString());
        }else if(throwable instanceof NullPointerException){
            //空指针异常
            LogUtils.e("空指针异常"+throwable.toString());
        }else{
            //其他异常
            LogUtils.e("其他异常"+throwable.toString());
        }
        return null;
    }
}
