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

### LICENSE
```
Copyright 2017 ALion

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limi
