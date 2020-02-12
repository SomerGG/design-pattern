package cn.xysomer.create.singleton.hungry;

/**
 * 饿汉式单例模式
 */
public class HungrySingleton {

    //
    private static final HungrySingleton SINGLETON = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return SINGLETON;
    }
}
