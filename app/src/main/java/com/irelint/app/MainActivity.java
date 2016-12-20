package com.irelint.app;

import android.os.Bundle;

import com.blankj.utilcode.utils.LogUtils;
import com.irelint.framework.base.BaseMvpActivity;
import com.irelint.framework.base.BaseObserver;
import com.irelint.framework.http.CallBack;
import com.irelint.framework.http.Request;
import com.irelint.framework.http.RequestHandler;

import java.util.List;

public class MainActivity extends BaseMvpActivity<MainPresenter,List<PromotionItem>> {

    @Override
    public MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter.loadData(new CallBack<List<PromotionItem>>() {
            @Override
            public void onSuccess(List<PromotionItem> data) {
                LogUtils.e("ok"+data.size());
            }

            @Override
            public void onFailed(Throwable e) {

            }
        });

        Request request = new Request();
        NewsService init = request.init("http://124.133.20.170/api/", NewsService.class);
        RequestHandler.convert(init.getPromotionList(),new BaseObserver(new CallBack<List<PromotionItem>>() {
            @Override
            public void onSuccess(List<PromotionItem> data) {
                LogUtils.e("ok2"+data.size());
            }

            @Override
            public void onFailed(Throwable e) {

            }
        }));
    }

    @Override
    public void showError(Throwable t) {

    }

    @Override
    public void renderModel(List<PromotionItem> data) {
        //渲染

    }

}
