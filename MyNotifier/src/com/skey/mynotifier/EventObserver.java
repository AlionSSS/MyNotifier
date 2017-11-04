package com.skey.mynotifier;

/**
 * Event 发生接口
 *
 * @author ALion
 * @version 2017/7/13 1:30
 */
public interface EventObserver {

    /**
     * 消息通知
     * @param info 消息
     */
    void onEvent(Object info);

}
