package com.skey.mynotifier;

/**
 * Notifier 功能接口
 *
 * @author ALion
 * @version 2017/7/13 1:29
 */
public interface MyNotifier {

    /**
     * 注册观察者
     *
     * @param key    用于标识observer，不能为null
     * @param observer 注册对应的observer接口，不能为null
     */
    void registerObserver(String key, EventObserver observer);

    /**
     * 注销观察者
     *
     * @param observer 注销对应的observer接口，不能为null
     */
    void unRegisterObserver(EventObserver observer);

    /**
     * 注销观察者
     *
     * @param key 按key值注销，不能为null
     */
    void unRegisterObserver(String key);

    /**
     * 注销所有观察者
     */
    void unRegisterAll();

    /**
     * 按key通知发生变化
     *
     * @param key 按key值通知对应的observer，不能为null
     * @param info  传递的信息
     */
    void notify(String key, Object info);

    /**
     * 通知所有observer
     *
     * @param info 传递的信息
     */
    void notifyAll(Object info);

}
