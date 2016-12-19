package com.irelint.framework.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.squareup.picasso.Picasso;

/**
 * 作者：当我遇上你 on 2016-12-20 00:29
 * 邮箱：cuishiying163@163.com
 */

public class BaseFragment extends Fragment {
    protected Activity mContext;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }
    @Override
    public void onResume() {
        Picasso.with(mContext).resumeTag(mContext);
        super.onResume();
    }
    @Override
    public void onPause() {
        Picasso.with(mContext).pauseTag(mContext);
        super.onPause();
    }
    @Override
    public void onDestroyView() {
        Picasso.with(mContext).cancelTag(mContext);
        super.onDestroyView();
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
     * 显示数据面
     */
    protected void showDataView(){

    }
    /**
     * 显示加载页面
     */
    protected void showLoadingView(){

    }
}
