package cn.xysomer.create.singleton.serializable;

import java.io.Serializable;

/**
 * 反序列化破坏单例
 * <p>
 * 序列化是将对象在内存中的状态转换为字节码的形式，从而转换一个 IO 流，写入到其他地方（可以是磁盘、网络 IO），将对象在内存中的状态永久保存下来。
 * <p>
 * 反序列化是将持久化的字节码内容，转换为 IO 流，通过 IO 流的读取，进而将读取的内容转换为 Java 对象，在转换过程中会重新创建对象 new。
 */
public class SerializableSingleton implements Serializable {

    //饿汉式
    public static final SerializableSingleton SERIALIZABLE_SINGLETON = new SerializableSingleton();

    private SerializableSingleton() {
    }

    public static SerializableSingleton getInstance() {
        return SERIALIZABLE_SINGLETON;
    }

    /**
     * 重写 readResolve 防止单例被破坏
     * <p>
     * 重写 readResolve 方法，只不过是覆盖了反序列化出来的对象，还是创建了两次，发生在 JVM 层面，相对来说比较安全。之前反序列化出来的对象会被 GC 回收
     *
     * @return
     */
    private Object readResolve() {
        return SERIALIZABLE_SINGLETON;
    }
}
