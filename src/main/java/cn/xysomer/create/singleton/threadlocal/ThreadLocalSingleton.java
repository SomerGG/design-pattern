package cn.xysomer.create.singleton.threadlocal;

/**
 * 注册式单例（容器式）
 * 伪线程安全 （保证线程内部的全局唯一，且天生线程安全）
 * ThreadLocalMap<线程本身, 要设置的值>
 * 可以使用 ThreadLocal 来实现多数据源动态切换
 */
public class ThreadLocalSingleton {

    private ThreadLocalSingleton() {
    }

    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance =
            new ThreadLocal<ThreadLocalSingleton>() {
                @Override
                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };

    public static ThreadLocalSingleton getInstance() {
        return threadLocalInstance.get();
    }
}
