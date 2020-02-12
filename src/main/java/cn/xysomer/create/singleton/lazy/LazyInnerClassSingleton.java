package cn.xysomer.create.singleton.lazy;

/**
 * 静态内部类懒汉式
 *
 */
//没有使用 synchronized，性能最优
//根据类加载的顺序，当加载主类的时候，先初始化内部类，执行相应逻辑
public class LazyInnerClassSingleton {

    //如果没使用的话，内部类是不加载的
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
    public static LazyInnerClassSingleton getInstance() {
        return LazyHolder.LAZY;
    }

    //默认不加载
    private static class LazyHolder {
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }
}
