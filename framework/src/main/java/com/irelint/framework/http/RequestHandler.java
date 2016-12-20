package com.irelint.framework.http;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：当我遇上你 on 2016-12-20 14:48
 * 邮箱：cuishiying163@163.com
 */

public class RequestHandler {
    /**
     * @param observable 被观察者
     * @param observer 观察者（监听者）
     * @param <T> 数据对象
     */
    public static <T> void convert(Observable<T> observable, Observer<T> observer){
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
