package cn.xysomer.create.singleton.lazy;

/**
 * 懒汉式单例
 */
public class LazySimpleSingleton {

    private static LazySimpleSingleton lazySimpleSingleton = null;

    private LazySimpleSingleton() {
    }

    //通过加锁控制每次只能有一个线程进行访问，其余线程需等待前一个线程释放锁之后才能进入
    public synchronized static LazySimpleSingleton getInstance() {
        if (null == lazySimpleSingleton) {
            lazySimpleSingleton = new LazySimpleSingleton();
        }
        return lazySimpleSingleton;
    }
}
