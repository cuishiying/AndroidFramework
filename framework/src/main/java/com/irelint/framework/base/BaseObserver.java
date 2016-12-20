package com.irelint.framework.base;

import com.irelint.framework.http.CallBack;

import rx.Observer;

/**
 * 作者：当我遇上你 on 2016-12-20 13:37
 * 邮箱：cuishiying163@163.com
 */

public class BaseObserver<T> implements Observer<T> {

    //T代表渲染的对象类型
    private CallBack<T> listener;

    public BaseObserver(CallBack<T> listener) {
        this.listener = listener;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        listener.onFailed(e);
    }

    @Override
    public void onNext(T t) {
        //主线程
        listener.onSuccess(t);
    }
}
