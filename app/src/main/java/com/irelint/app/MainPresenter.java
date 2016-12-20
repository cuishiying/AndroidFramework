package com.irelint.app;

import com.irelint.framework.base.BaseObserver;
import com.irelint.framework.base.BasePresenter;
import com.irelint.framework.base.IBaseView;
import com.irelint.framework.http.CallBack;
import com.irelint.framework.http.RequestHandler;

import java.util.List;

import rx.Observable;

/**
 * 作者：当我遇上你 on 2016-12-20 15:08
 * 邮箱：cuishiying163@163.com
 */

public class MainPresenter extends BasePresenter<IBaseView>{
    public void loadData(){
        NewsService service = mRequest.init("http://124.133.20.170/api/", NewsService.class);
        Observable<List<PromotionItem>> promotionList = service.getPromotionList();
        RequestHandler.convert(promotionList,new BaseObserver(new BaseCallBack<List<PromotionItem>>()));
    }
    public void loadData(CallBack c){
        NewsService service = mRequest.init("http://124.133.20.170/api/", NewsService.class);
        Observable<List<PromotionItem>> promotionList = service.getPromotionList();
        RequestHandler.convert(promotionList,new BaseObserver(c));
    }
}
