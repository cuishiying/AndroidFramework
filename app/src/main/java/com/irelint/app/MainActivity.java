package com.irelint.app;

import android.os.Bundle;

import com.irelint.framework.base.BaseMvpActivity;

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
        mPresenter.loadData();
    }

    @Override
    public void renderModel(List<PromotionItem> data) {

    }

}
