package cn.xysomer.behavior.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 具体的被观察者对象
 * @Author Somer
 * @Date 2020-02-14 14:50
 */
public class ObserverAbleUser implements IObserverAble {

    private List<IObserver> observerList;

    private String message;

    private static final String PUBLISHER = "信息中心";

    public ObserverAbleUser() {
        observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(IObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        if (!observerList.isEmpty()) {
            observerList.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        if (!observerList.isEmpty()) {
            for (int i = 0; i < observerList.size(); i++) {
                observerList.get(i).update(this.message);
            }
        }
    }

    public void publishMessage(String message) {
        this.message = message;
        System.out.println(PUBLISHER + "发布了一条通知，内容是：" + this.message);
        notifyObservers();//通知所有的观察者
    }
}
