# MyNotify
一个简易的消息分发机制

### What you need to know?
1. 单例设计模式
2. 观察者设计模式
3. 熟悉HashMap、HashSet、Interface

### How to use?
- 按value注册观察者
```java
MyNotifierImpl.getNotifier().registerObserver("Chinese", new EventObserver() {
            @Override
            public void onEvent(Object info) {
                System.out.println((String) info);
            }
        });
```
- 按value分发消息
```java
MyNotifierImpl.getNotifier().notify("Chinese", "你好");
```

