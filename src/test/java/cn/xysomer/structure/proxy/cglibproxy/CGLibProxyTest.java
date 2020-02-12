package cn.xysomer.structure.proxy.cglibproxy;

import cn.xysomer.structure.proxy.jdkproxy.Customer;
import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @Description cglib 动态代理测试
 * @Author Somer
 * @Date 2020-02-12 19:29
 */
public class CGLibProxyTest {

    public static void main(String[] args) {
        try {
//            System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/johiroshi/cglib_class");
            Customer customer = (Customer) new CGLibMeipo().getInstance(Customer.class);
            System.out.println(customer);
            customer.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
