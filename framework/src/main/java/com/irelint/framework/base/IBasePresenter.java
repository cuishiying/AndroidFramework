package com.irelint.framework.base;

/**
 * 作者：当我遇上你 on 2016-12-20 01:41
 * 邮箱：cuishiying163@163.com
 */

public interface IBasePresenter<V> {
    /**
     * 绑定View
     * @param mvpView
     */
    void attachView(V mvpView);

    /**
     * 解绑View
     */
    void detachView();
}
