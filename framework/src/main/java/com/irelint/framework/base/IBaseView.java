package com.irelint.framework.base;

import android.app.Activity;

/**
 * 作者：当我遇上你 on 2016-12-20 01:37
 * 邮箱：cuishiying163@163.com
 */

public interface IBaseView<M> {
    /**
     * 显示加载页面
     */
    void showLoading();

    /**
     * 显示空页面
     */
    void showEmpty();

    /**
     * 显示错误页面
     * @param t
     */
    void showError(Throwable t);

    /**
     * 渲染页面
     * @param data
     */
    void renderModel(M data);

    /**
     * 获取上下文
     * @return
     */
    Activity getContext();
}
