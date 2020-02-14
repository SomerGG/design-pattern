package cn.xysomer.behavior.observe;

/**
 * @Description 观察者模式测试
 * @Author Somer
 * @Date 2020-02-14 14:56
 */
public class ObserverTest {

    public static void main(String[] args) {
        ObserverAbleUser publisher = new ObserverAbleUser();

        //创建观察者
        IObserver tom = new ObserverUser("tom");
        IObserver mic = new ObserverUser("mic");
        IObserver james = new ObserverUser("james");

        //把观察者注册到集合
        publisher.registerObserver(tom);
        publisher.registerObserver(mic);
        publisher.registerObserver(james);

        //被观察者发送一条消息
        publisher.publishMessage("Java 是世界上最好的语言！！！");

        System.out.println("----------------------");

        //移除其中一个观察者
        publisher.removeObserver(james);
        //重新发送消息
        publisher.publishMessage("麻烦给我来一个对象！！！");
    }
}
