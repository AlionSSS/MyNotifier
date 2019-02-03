package com.skey.mynotifier;

/**
 * 订阅/分发 功能接口
 *
 * @author ALion
 * @version 2017/7/13 1:29
 */
public interface MyNotifier {

    /**
     * 订阅-注册观察者
     *
     * @param key    用于标识observer，不能为null
     * @param observer 注册对应的observer接口，不能为null
     */
    void subscribe(String key, EventObserver observer);

    /**
     * 取消订阅-注销观察者
     *
     * @param observer 注销对应的observer接口，不能为null
     */
    void unSubscribe(EventObserver observer);

    /**
     * 取消订阅-注销观察者
     *
     * @param key 按key值注销，不能为null
     */
    void unSubscribe(String key);

    /**
     * 取消订阅-注销所有观察者
     */
    void unRegisterAll();

    /**
     * 分发-按key分发
     *
     * @param key 按key值通知对应的observer，不能为null
     * @param info  传递的信息
     */
    void post(String key, Object info);

    /**
     * 分发-所有observer
     *
     * @param info 传递的信息
     */
    void postAll(Object info);

}
