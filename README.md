# MyNotify
一个简易的消息分发机制

### 你可能需要知道
1. 单例设计模式
2. 观察者设计模式
3. 熟悉HashMap、HashSet、Interface

### 使用示例
- 按value注册观察者
```java
MyNotify.getNotifier().registerObserver("Chinese", new EventObserver() {
            @Override
            public void onEvent(Object info) {
                System.out.println("info = " info);
            }
        });
```
- 按value分发消息
```java
MyNotify.getNotifier().notify("Chinese", "hello");
```

