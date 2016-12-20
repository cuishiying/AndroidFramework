package com.irelint.framework.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者：当我遇上你 on 2016-12-20 11:49
 * 邮箱：cuishiying163@163.com
 */

public abstract class BaseMvpFragment<T extends BasePresenter,M> extends BaseFragment implements IBaseView<M>{
    public T mPresenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPresenter = initPresenter();
        if(null==mPresenter){
            throw new RuntimeException("请在Activity或者Fragment中创建Presenter对象");
        }
        mPresenter.attachView(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        if(null!=mPresenter){
            mPresenter.detachView();
        }
        super.onDestroyView();
    }

    public abstract T initPresenter();

    @Override
    public void showLoading() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showError(Throwable t) {

    }

    @Override
    public abstract void renderModel(M data);

    @Override
    public Activity getContext() {
        return mContext;
    }
}
