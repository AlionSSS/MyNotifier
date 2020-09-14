# MyNotifier
一个简易的订阅/分发消息的工具

### Download
[Click Me (´･ω･`)](https://github.com/AlionSSS/MyNotifier/releases/download/1.0.1/MyNotifier.jar)

### How to use?
- 按key订阅消息
```java
Notify.getNotifier().subscribe("Chinese", new EventObserver() {
    @Override
    public void onEvent(Object info) {
        System.out.println("info = " + info);
    }
});
```
- 按key分发消息
```java
Notify.getNotifier().post("Chinese", "hello");
```

### LICENSE
```
Copyright 2017~2019 ALion

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
