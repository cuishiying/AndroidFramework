package com.irelint.framework.http;



/**
 * Created by Dante on 2016/3/16.
 */
public interface OnRequestListener<T> {

    void onSuccess(T data);

    void onFailed(Throwable e);
}
