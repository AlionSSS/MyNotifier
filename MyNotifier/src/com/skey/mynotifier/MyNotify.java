package com.skey.mynotifier;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 消息分发 具体实现类
 *
 * @author ALion
 * @version 2017/6/21 18:29
 */

public class MyNotify implements MyNotifier {

    private static class Inner {
        private static MyNotifier instance = new MyNotify();
    }

    public static MyNotifier getNotifier() {
        return Inner.instance;
    }

    private MyNotify() {
        mObservers = new HashMap<>();
    }

    /**
     * 观察者集合
     * 注: key的String类型可以根据个人喜好修改为Integer
     */
    private static HashMap<String, HashSet<EventObserver>> mObservers;

    /**
     * 注册观察者
     *
     * @param key    用于标识observer，不能为null
     * @param observer 注册对应的observer接口，不能为null
     */
    @Override
    public void registerObserver(String key, EventObserver observer) {
        checkObserver(observer);
        checkKey(key);

        HashSet<EventObserver> set = mObservers.get(key);
        if (set == null) {
            set = new HashSet<>();
        }
        set.add(observer);
        mObservers.put(key, set);
    }

    /**
     * 注销观察者
     *
     * @param observer 注销对应的observer接口，不能为null
     */
    @Override
    public void unRegisterObserver(EventObserver observer) {
        checkObserver(observer);

        for (Map.Entry<String, HashSet<EventObserver>> entry : mObservers.entrySet()) {
            HashSet<EventObserver> set = entry.getValue();
            if (set.contains(observer)) {
                set.remove(observer);
                break;
            }
        }
    }

    /**
     * 注销观察者
     *
     * @param key 按key值注销，不能为null
     */
    @Override
    public void unRegisterObserver(String key) {
        checkKey(key);

        mObservers.remove(key);
    }

    /**
     * 注销所有观察者
     */
    @Override
    public void unRegisterAll() {
        mObservers.clear();
    }

    /**
     * 按value通知发生变化
     *
     * @param key 按key值通知对应的observer，不能为null
     * @param info  传递的信息
     */
    @Override
    public void notify(String key, Object info) {
        checkKey(key);

        if (mObservers.containsKey(key)) {
            HashSet<EventObserver> set = mObservers.get(key);
            for (EventObserver observer : set) {
                observer.onEvent(info);
            }
        }
    }

    /**
     * 通知所有observer
     *
     * @param info 传递的信息
     */
    @Override
    public void notifyAll(Object info) {
        for (Map.Entry<String, HashSet<EventObserver>> entry : mObservers.entrySet()) {
            for (EventObserver observer : entry.getValue()) {
                observer.onEvent(info);
            }
        }
    }

    private void checkObserver(EventObserver observer) {
        if (observer == null) {
            throw new IllegalArgumentException("observer should not be null!");
        }
    }

    private void checkKey(String key) {
        if (key == null) {
            throw new IllegalArgumentException("key should not be null!");
        }
    }
}
