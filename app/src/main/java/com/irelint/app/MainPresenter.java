package com.irelint.app;

import com.irelint.framework.base.BaseObserver;
import com.irelint.framework.http.CallBack;
import com.irelint.framework.http.RequestHandler;

import java.util.List;

import rx.Observable;

import static com.irelint.app.SApp.mService;

/**
 * 作者：当我遇上你 on 2016-12-20 15:08
 * 邮箱：cuishiying163@163.com
 */

public class MainPresenter extends SBasePresenter{
    public void loadData(){
        Observable<List<PromotionItem>> promotionList = mService.getPromotionList();
        RequestHandler.convert(promotionList,new BaseObserver(new BaseCallBack<List<PromotionItem>>()));
    }
    public void loadData(CallBack c){
        Observable<List<PromotionItem>> promotionList = mService.getPromotionList();
        RequestHandler.convert(promotionList,new BaseObserver(c));
    }
}
