package cn.xysomer.structure.proxy.jdkproxy;

import cn.xysomer.structure.proxy.staticproxy.IOrderService;
import cn.xysomer.structure.proxy.staticproxy.Order;
import cn.xysomer.structure.proxy.staticproxy.OrderService;
import cn.xysomer.structure.proxy.staticproxy.OrderServiceStaticProxy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JdkProxyTest {

    //动态代理
    public static void main(String[] args) {
        try {
            Order order = new Order();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse("2020-02-12");

            order.setCreateTime(date.getTime());
            IOrderService orderService = (IOrderService) new OrderServiceDynamicProxy().getInstance(new OrderService());
            orderService.insert(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
