package cn.xysomer.create.singleton;

import cn.xysomer.create.singleton.lazy.LazySimpleSingleton;
import cn.xysomer.create.singleton.threadlocal.ThreadLocalSingleton;

public class ExecutorThread implements Runnable {

    @Override
    public void run() {
//        LazySimpleSingleton singleton = LazySimpleSingleton.getInstance();
        ThreadLocalSingleton singleton = ThreadLocalSingleton.getInstance();
//        System.out.println("线程" + Thread.currentThread().getName() + ":" + singleton);
        System.out.println("线程" + Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
        System.out.println("线程" + Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
        System.out.println("线程" + Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
        System.out.println("线程" + Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
        System.out.println("线程" + Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
        System.out.println("线程" + Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
        System.out.println("线程" + Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
        System.out.println("线程" + Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
        System.out.println("线程" + Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
        System.out.println("线程" + Thread.currentThread().getName() + ":" + singleton);
    }
}
