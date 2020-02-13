package cn.xysomer.structure.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author Somer
 * @Date 2020-02-12 19:11
 */
public class CGLibMeiPo implements MethodInterceptor {

    /**
     * 生成代理对象
     *
     * @param clazz
     * @return
     * @throws Exception
     */
    public Object getInstance(Class<?> clazz) throws Exception {
        Enhancer enhancer = new Enhancer();//相当于 Proxy，代理的工具类
        enhancer.setSuperclass(clazz);//传入的父类
        enhancer.setCallback(this);//回调下面的 intercept
        return enhancer.create();
    }

    /**
     * 拦截的方法
     *
     * @param o           代理对象
     * @param method      要被拦截的方法
     * @param objects     要被拦截方法的参数
     * @param methodProxy 要触发父类的方法对象
     * @return
     * @throws Throwable
     */
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        /**
         * 因为生成的类是子类，生成的子类是为了通过继承父类实现父类的方法，以便进行相应增强，增强之前需要先调用父类的相关逻辑
         */
        Object object = methodProxy.invokeSuper(o, objects);
        after();
        return object;
    }

    private void before() {
        System.out.println("媒婆已经确认你找对象的需求");
        System.out.println("开始物色");
    }

    private void after() {
        System.out.println("ok 的话，开始交往");
    }
}
