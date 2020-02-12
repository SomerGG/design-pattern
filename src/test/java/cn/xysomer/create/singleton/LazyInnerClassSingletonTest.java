package cn.xysomer.create.singleton;

import cn.xysomer.create.singleton.lazy.LazyInnerClassSingleton;

import java.lang.reflect.Constructor;

public class LazyInnerClassSingletonTest {

    public static void main(String[] args) {
        try {
            //反射破坏单例
            Class<?> clazz = LazyInnerClassSingleton.class;
            //通过反射获取到私有的构造方法
            Constructor constructor = clazz.getDeclaredConstructor(null);
            //强制访问
            constructor.setAccessible(true);
            //暴力初始化
            Object object1 = constructor.newInstance();
            //调用了两次构造方法，相当于 new 了两次
            Object object2 = constructor.newInstance();

//            Object object2 = LazyInnerClassSingleton.getInstance();

            System.out.println(object1 == object2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}