package cn.xysomer.behavior.observe;

/**
 * @Description 抽象的被观察者
 * @Author Somer
 * @Date 2020-02-14 14:45
 */
public interface IObserverAble {

    /**
     * 添加观察者
     *
     * @param observer
     */
    void registerObserver(IObserver observer);

    /**
     * 移除观察者
     *
     * @param observer
     */
    void removeObserver(IObserver observer);

    /**
     * 通知观察者
     */
    void notifyObservers();
}
