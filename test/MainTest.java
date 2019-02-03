import com.skey.mynotifier.EventObserver;
import com.skey.mynotifier.MyNotifier;
import com.skey.mynotifier.Notify;

/**
 * MainTest
 *
 * @author ALion
 * @version 2017/11/4 20:49
 */
public class MainTest {

    public static void main(String[] args) {
        MyNotifier notifier = Notify.getNotifier();
        notifier.subscribe("China", new EventObserver() {
            @Override
            public void onEvent(Object info) {
                System.out.println("info = " + info);
            }
        });
        notifier.subscribe("China", new EventObserver() {
            @Override
            public void onEvent(Object info) {
                System.out.println("info = " + info);
            }
        });
        notifier.subscribe("American", new EventObserver() {
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
                    MyNotifier notifier = Notify.getNotifier();
                    notifier.post("China", "你好1");

                    Thread.sleep(3000);
                    notifier.post("American", "hello");

                    Thread.sleep(10000);
                    notifier.post("China", "你好2");
                    notifier.post("American", "hello2");

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
                    Notify.getNotifier().unSubscribe("China");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
