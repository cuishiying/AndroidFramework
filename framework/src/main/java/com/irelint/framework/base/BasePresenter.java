package com.irelint.framework.base;

/**
 * 作者：当我遇上你 on 2016-12-20 01:42
 * 邮箱：cuishiying163@163.com
 */

public class BasePresenter<V extends IBaseView>{

    private V mView;

    /**
     * 绑定View
     * @param mvpView
     */
    public void attachView(V mvpView) {
        this.mView = mvpView;
    }

    /**
     * 解绑View
     */
    public void detachView() {
        this.mView = null;
    }

    /**
     * 判断 view是否为空
     * @return
     */
    public boolean isViewAttached() {
        return mView != null;
    }
    /**
     * 返回目标view
     * @return
     */
    public V getMvpView() {
        return mView;
    }
    /**
     * 检查view和presenter是否连接
     */
    public void checkViewAttached() {
        if (!isViewAttached()) throw new RuntimeException("Please call Presenter.attachView(MvpView) before" +
                " requesting data to the Presenter");
    }
}
