package cn.xysomer.structure.proxy.staticproxy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StaticProxyTest {

    public static void main(String[] args) {
//        Father father = new Father(new Son());
//        father.findLove();

        //静态代理实现路由选择
        try {
            Order order = new Order();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse("2020-02-12");

            order.setCreateTime(date.getTime());
            IOrderService orderService = new OrderServiceStaticProxy(new OrderService());
            orderService.insert(order);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
