package com.irelint.framework.common;

/**
 * 作者：当我遇上你 on 2016-12-20 10:11
 * 邮箱：cuishiying163@163.com
 */

public class Constants {
    //url
    public static final String MEIZI_HOST = "http://gank.io/api/";

    //HostType
    public static final int TYPE_MEIZI = 0;

    /**
     * 获取对应的host
     *
     * @param hostType host类型
     * @return host
     */
    public static String getHost(int hostType) {
        String host;
        switch (hostType) {
            case TYPE_MEIZI:
                host = MEIZI_HOST;
                break;
            default:
                host = "";
                break;
        }
        return host;
    }
}
