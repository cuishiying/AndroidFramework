package com.irelint.framework.http;

import com.irelint.framework.common.Constants;

import java.util.HashMap;
import java.util.Map;

import retrofit2.adapter.rxjava.HttpException;
import retrofit2.adapter.rxjava.Result;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * 作者：当我遇上你 on 2016-12-20 10:26
 * 邮箱：cuishiying163@163.com
 */

public class Request {
    /**
     * 普通的网络请求
     * @param observable
     * @param <T>
     * @return
     */
    private <T> Observable<T> convert(Observable<T> observable){
        return observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 需要token的请求
     * @param observable
     * @param <T>
     * @return
     */
    private <T> Observable<T> convertToken(final Observable<T> observable){
        return Observable
                .just(null)
                .flatMap(new Func1<Object, Observable<T>>() {
                    @Override
                    public Observable<T> call(Object o) {
                        return observable;
                    }
                })
                .retryWhen(new Func1<Observable<? extends Throwable>, Observable<?>>() {
                    @Override
                    public Observable<?> call(Observable<? extends Throwable> observable) {
                        // Here we just retry 3 time
                        return observable
                                .zipWith(Observable.range(1, 3), new Func2<Throwable, Integer, Throwable>() {
                                    @Override
                                    public Throwable call(Throwable throwable, Integer integer) {
                                        //token过期
                                        return throwable;
                                    }
                                })
                                .flatMap(new Func1<Throwable, Observable<?>>() {
                                    @Override
                                    public Observable<?> call(Throwable throwable) {
                                        if (throwable instanceof HttpException) {
                                            // Request token refresh if request UserInfo fail
                                            return refreshToken().doOnNext(new Action1<Object>() {

                                                @Override
                                                public void call(Object o) {
                                                    //刷新token
                                                }
                                            });
                                        }
                                        return Observable.just(throwable);
                                    }
                                });
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
    /**
     * 请求刷新token接口
     */
    public Observable<Result<Object>> refreshToken(){
        HashMap<String, String> params = new HashMap<>();
        return RetrofitManager.getInstance(Constants.TYPE_MEIZI).refreshToken(params);
    }

    class BaseObserver<T> implements Observer<T> {

        OnRequestListener<T> listener;

        public BaseObserver(OnRequestListener<T> listener) {
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
    //***********************************用法**************************************

    /**
     * 获取token
     */
    public void getToken(Map<String,String> params, OnRequestListener listener){
        convert(RetrofitManager.getInstance(Constants.TYPE_MEIZI).refreshToken(params))
                .subscribe(new BaseObserver(listener));
    }
}
