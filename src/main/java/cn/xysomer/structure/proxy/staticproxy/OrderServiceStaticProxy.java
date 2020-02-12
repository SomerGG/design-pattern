package cn.xysomer.structure.proxy.staticproxy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description 切换数据源的静态代理类
 * @Author Somer
 * @Date 2020-02-12 15:58
 */
public class OrderServiceStaticProxy implements IOrderService {

    private IOrderService orderService;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy");

    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public int insert(Order order) {
        before();
        Long createTime = order.getCreateTime();
        //获取应当添加到到数据源的路由
        Integer router = Integer.valueOf(format.format(new Date(createTime)));
        System.out.println("静态代理自动分配到【DB_" + router + "】数据源进行处理");
        DynamicDataSourceEntry.set(router);
        orderService.insert(order);
        after();
        return 0;
    }

    public void before() {
        System.out.println("Proxy Before Method");
    }

    public void after() {
        System.out.println("Proxy After Method");
    }
}
