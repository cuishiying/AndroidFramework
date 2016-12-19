package com.irelint.framework.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

/**
 * 作者：当我遇上你 on 2016-12-19 23:59
 * 邮箱：cuishiying163@163.com
 */

public class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
    }

    @Override
    protected void onResume() {
        Picasso.with(this).resumeTag(this);
        super.onResume();
    }

    @Override
    protected void onPause() {
        Picasso.with(this).pauseTag(this);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        AppManager.getAppManager().finishActivity(this);
        super.onDestroy();
    }

    /**
     * 显示空页面
     */
    protected void showEmptyView(){

    }
    /**
     * 显示错误页面
     */
    protected void showErrorView(){

    }
    /**
     * 显示数据页面
     */
    protected void showDataView(){

    }
    /**
     * 显示加载页面
     */
    protected void showLoadingView(){

    }
}
