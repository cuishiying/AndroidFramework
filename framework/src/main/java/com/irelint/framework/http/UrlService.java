package com.irelint.framework.http;

import java.util.Map;

import retrofit2.adapter.rxjava.Result;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * 作者：当我遇上你 on 2016-12-20 01:53
 * 邮箱：cuishiying163@163.com
 */

public interface UrlService {
    //刷新token
    @Headers({"Authorization:Basic c2hhbWFuY2xpZW50OnNoYW1hbnNlY31111=="})
    @POST("oauth/token")
    Observable<Result<Object>> refreshToken(@QueryMap Map<String, String> map);
}
