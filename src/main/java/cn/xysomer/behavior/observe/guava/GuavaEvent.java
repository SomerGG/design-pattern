package cn.xysomer.behavior.observe.guava;

import com.google.common.eventbus.Subscribe;

/**
 * @Description Guava 实现的观察者
 * @Author Somer
 * @Date 2020-02-14 15:18
 */
public class GuavaEvent {

    @Subscribe
    public void subscribe(String params) {
        System.out.println("执行 subscribe 方法，传入的参数是：" + params);
    }
}
