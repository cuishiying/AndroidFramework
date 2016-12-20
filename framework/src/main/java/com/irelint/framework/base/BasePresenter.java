package com.irelint.framework.base;

import com.irelint.framework.http.CallBack;
import com.irelint.framework.http.Error;
import com.irelint.framework.http.ErrorHandler;
import com.irelint.framework.http.Request;

/**
 * 作者：当我遇上你 on 2016-12-20 01:42
 * 邮箱：cuishiying163@163.com
 */

public class BasePresenter<V extends IBaseView>{

    private V mView;
    protected Request mRequest;

    public BasePresenter() {
        if(null==mRequest){
            mRequest = new Request();
        }
    }

    public BasePresenter(Request request) {
        this.mRequest = request;
    }

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

    public class BaseCallBack<M> implements CallBack<M> {

        @Override
        public void onSuccess(final M data) {
            //当前线程为主线程
            if (null != data) {
                handleData(data);
            }else {
                handleNullData();
            }
        }

        @Override
        public void onFailed(Throwable e) {
            if(null!=mView){
                mView.showError(e);
                Error err = ErrorHandler.handle(e);
                switch (err.code){
                    case 400:
                        //请求格式错误
                        break;
                    case 401:
                        //Unauthorized未授权
                        break;
                    case 404:
                        //url错误
                        break;
                    case 500:
                        //服务器错误
                        break;
                    case 502:
                        //网关错误
                        break;
                    default:
                        break;
                }
            }
        }

        /**
         * 处理null
         */
        protected void handleNullData() {
            mView.showEmpty();
        }

        /**
         * 处理业务，渲染页面
         * @param data
         */
        protected void handleData(M data) {
            if(null!=mView){
                mView.renderModel(data);
            }
        }
    }
}
