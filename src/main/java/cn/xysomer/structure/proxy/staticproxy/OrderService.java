package cn.xysomer.structure.proxy.staticproxy;

/**
 * @Description 订单服务实现
 * @Author Somer
 * @Date 2020-02-12 15:50
 */
public class OrderService implements IOrderService {

    private OrderDao orderDao;

    public OrderService() {
        orderDao = new OrderDao();
    }

    @Override
    public int insert(Order order) {
        System.out.println("OrderService 调用 OrderDao 创建订单");
        return orderDao.insert(order);
    }
}
