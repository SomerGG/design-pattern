package cn.xysomer.structure.proxy.staticproxy;

/**
 * 订单持久操作
 */
public class OrderDao {

    public int insert(Order order) {
        System.out.println("OrderDao 创建订单成功！");
        return 1;
    }
}
