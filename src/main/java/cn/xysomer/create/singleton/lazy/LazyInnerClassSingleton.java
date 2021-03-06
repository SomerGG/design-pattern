package cn.xysomer.create.singleton.lazy;

/**
 * 静态内部类懒汉式
 *
 */
//没有使用 synchronized，性能最优
public class LazyInnerClassSingleton {

    private LazyInnerClassSingleton(){
        if (null != LazyHolder.LAZY) {//防止反射攻击
            throw new RuntimeException("不允许构建多个实例");
        }
    }

    //LazyHolder 里面的逻辑需要等到外部方法调用时才会执行
    //巧妙利用内部类的特性
    //JVM 底层执行逻辑，完美避开了线程安全问题
    //static 是为了使单例的空间共享
    //final 是保证该方法不会被重写、重载
    public static final LazyInnerClassSingleton getInstance() {
        return LazyHolder.LAZY;
    }

    //如果没使用的话，内部类是不加载的，当调用 getInstance 时才会进行加载该静态内部类
    private static class LazyHolder {
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }
}
