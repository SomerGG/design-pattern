package cn.xysomer.structure.proxy.jdkproxy;

import cn.xysomer.structure.proxy.staticproxy.DynamicDataSourceEntry;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description 订单动态代理类，基于 jdk 动态代理实现
 * @Author Somer
 * @Date 2020-02-12 16:17
 */
public class OrderServiceDynamicProxy implements InvocationHandler {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy");
    //被代理对象，把引用保存下来
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    /**
     * 对代理实例进行方法调用
     *
     * @param proxy  代理对象
     * @param method 目标类的真实方法
     * @param args   目标方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args[0]);
        Object object = method.invoke(target, args);
        after();
        return object;
    }

    public void after() {
        //还原成默认的数据源
        DynamicDataSourceEntry.restore();
        System.out.println("Proxy after method");
    }

    /**
     * @param target 订单对象
     */
    public void before(Object target) {
        //数据源切换
        try {
            System.out.println("Proxy before method");
            //反射获取
            //约定优于配置，约定根据创建时间进行路由分配
            Long createTime = (Long) target.getClass().getMethod("getCreateTime").invoke(target);
            Integer router = Integer.valueOf(format.format(new Date(createTime)));
            System.out.println("动态代理自动分配到【DB_" + router + "】数据源处理");
            DynamicDataSourceEntry.set(router);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
