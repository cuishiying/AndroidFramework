package com.irelint.app;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * 作者：当我遇上你 on 2016-12-20 15:01
 * 邮箱：cuishiying163@163.com
 */

public interface NewsService {
    //活动列表
    @GET("mobile/activity")
    Observable<List<PromotionItem>> getPromotionList();
}
