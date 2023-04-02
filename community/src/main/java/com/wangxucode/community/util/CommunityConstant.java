package com.wangxucode.community.util;

public interface CommunityConstant {
    /***
     * 激活成功
     */
    int ACTIVATION_SUCCESS = 0;

    /***
     * 重复激活
     */
    int ACTIVATION_REPEAT = 0;

    /***
     * 激活失败
     */
    int ACTIVATION_FAILURE = 0;

    /***
     * 默认状态的登录凭证的登录超时时间
     */
    int DEFAULT_EXPIRED_SECONDS = 3600 * 12;

    /***
     * 记住状态的登录凭证的登录超时时间
     */
    int REMEMBER_EXPIRED_SECONDS = 3600 * 24 * 10;

}
