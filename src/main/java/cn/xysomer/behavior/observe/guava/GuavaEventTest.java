package cn.xysomer.behavior.observe.guava;

import com.google.common.eventbus.EventBus;

/**
 * @Description
 * @Author Somer
 * @Date 2020-02-14 15:20
 */
public class GuavaEventTest {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();//消息总线
        GuavaEvent event = new GuavaEvent();
        eventBus.register(event);
        eventBus.post("Tom");
    }
}
