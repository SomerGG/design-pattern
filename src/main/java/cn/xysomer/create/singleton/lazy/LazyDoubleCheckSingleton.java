package cn.xysomer.create.singleton.lazy;

/**
 * 懒汉式单例，双重校验
 *
 */
public class LazyDoubleCheckSingleton {

    //volatile 禁止cpu指令重排序
    private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;

    private LazyDoubleCheckSingleton(){}

    //适中的方案，在线程进入之后再进行加锁
    public static LazyDoubleCheckSingleton getInstance() {
        if (null == lazyDoubleCheckSingleton) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (null == lazyDoubleCheckSingleton) {
                    return new LazyDoubleCheckSingleton();
                }
            }
            lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
        }
        return lazyDoubleCheckSingleton;
    }
}
