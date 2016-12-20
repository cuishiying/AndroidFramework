package com.irelint.framework.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * 作者：当我遇上你 on 2016-12-20 11:36
 * 邮箱：cuishiying163@163.com
 */

public abstract class BaseMvpActivity<T extends BasePresenter,M> extends BaseActivity implements IBaseView<M>{

    public T mPresenter;
    public abstract T initPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
        if(null==mPresenter){
            throw new RuntimeException("请在Activity或者Fragment中创建Presenter对象");
        }
        mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        if(mPresenter!=null){
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    @Override
    public void showLoading() {
        //统一显示加载页面
    }

    @Override
    public void showEmpty() {
        //统一显示空页面
    }

    @Override
    public void showError(Throwable t) {
        //统一显示错误页面
    }

    @Override
    public abstract void renderModel(M data);

    @Override
    public Activity getContext() {
        return this;
    }
}
