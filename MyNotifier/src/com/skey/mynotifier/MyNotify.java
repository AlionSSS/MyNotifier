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

    private static final MyNotifier mInstance = new MyNotify();

    public static MyNotifier getNotifier() {
        return mInstance;
    }

    private MyNotify() {
    }

    /**
     * 观察者集合
     * 注: value的String类型可以根据个人喜好修改为Integer
     */
    private static HashMap<String, HashSet<EventObserver>> mObservers = new HashMap<>();

    /**
     * 注册观察者
     *
     * @param value    用于标识observer，不能为null
     * @param observer 注册对应的observer接口，不能为null
     */
    @Override
    public void registerObserver(String value, EventObserver observer) {
        checkObserver(observer);
        checkValue(value);

        HashSet<EventObserver> set = mObservers.get(value);
        if (set == null) {
            set = new HashSet<>();
        }
        set.add(observer);
        mObservers.put(value, set);
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
     * @param value 按value值注销，不能为null
     */
    @Override
    public void unRegisterObserver(String value) {
        checkValue(value);

        mObservers.remove(value);
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
     * @param value 按value值通知对应的observer，不能为null
     * @param info  传递的信息
     */
    @Override
    public void notify(String value, Object info) {
        checkValue(value);

        for (Map.Entry<String, HashSet<EventObserver>> entry : mObservers.entrySet()) {
            if (value.equals(entry.getKey())) {
                for (EventObserver observer : entry.getValue()) {
                    observer.onEvent(info);
                }
                break;
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

    private void checkValue(String value) {
        if (value == null) {
            throw new IllegalArgumentException("value should not be null!");
        }
    }
}
