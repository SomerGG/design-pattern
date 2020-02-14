package cn.xysomer.behavior.observe;

/**
 * @Description 抽象的观察者
 * @Author Somer
 * @Date 2020-02-14 14:44
 */
public interface IObserver {

    /**
     * 接收来自被观察者发送的消息，当被观察者调用 notifyObservers 时，回调该方法
     *
     * @param message
     */
    void update(String message);
}
