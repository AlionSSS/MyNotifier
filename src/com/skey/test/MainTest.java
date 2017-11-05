package com.skey.test;

import com.skey.mynotifier.EventObserver;
import com.skey.mynotifier.MyNotifier;
import com.skey.mynotifier.MyNotify;

/**
 * MainTest
 *
 * @author ALion
 * @version 2017/11/4 20:49
 */
public class MainTest {

    public static void main(String[] args) {
        MyNotifier notifier = MyNotify.getNotifier();
        notifier.registerObserver("China", new EventObserver() {
            @Override
            public void onEvent(Object info) {
                System.out.println("info = " + info);
            }
        });
        notifier.registerObserver("China", new EventObserver() {
            @Override
            public void onEvent(Object info) {
                System.out.println("info = " + info);
            }
        });
        notifier.registerObserver("American", new EventObserver() {
            @Override
            public void onEvent(Object info) {
                System.out.println("info = " + info);
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    MyNotifier notifier = MyNotify.getNotifier();
                    notifier.notify("China", "你好1");

                    Thread.sleep(3000);
                    notifier.notify("American", "hello");

                    Thread.sleep(10000);
                    notifier.notify("China", "你好2");
                    notifier.notify("American", "hello2");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        for (int i = 0; i < 99; i++) {
            try {
                Thread.sleep(500);
                System.out.println("MainThread ---> " + i);

                if (i == 20) {
                    System.out.println("注销掉China");
                    MyNotify.getNotifier().unRegisterObserver("China");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
