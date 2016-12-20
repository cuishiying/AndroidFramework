package com.irelint.app;

import android.os.Bundle;

import com.irelint.framework.base.BaseMvpActivity;
import com.irelint.framework.http.CallBack;

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

            }

            @Override
            public void onFailed(Throwable e) {

            }
        });
    }

    @Override
    public void showError(Throwable t) {

    }

    @Override
    public void renderModel(List<PromotionItem> data) {
        //渲染

    }

}
