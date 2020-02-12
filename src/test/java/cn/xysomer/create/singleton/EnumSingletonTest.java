package cn.xysomer.create.singleton;

import cn.xysomer.create.singleton.register.EnumSingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class EnumSingletonTest {

    //将新建的对象 s2 序列化，反序列化的时候重新创建
//    public static void main(String[] args) {
//        //枚举的 class 文件反编译之后，没有无参构造方法，属于饿汉式的单例，本身就是线程安全的
//        //只需要破坏序列化单例，是如何避免的？
//        //通过观看源码得知，调用 readObject时，调用 readObject0，根据 TC_ENUM 得知调用的 readEnum方法，在 readEnum 中，
//        //通过 Enum.valueOf((Class) c, name)直接返回，即通过一个类名和枚举的一个名字来确定这个唯一的枚举，被存入 jvm 中。
//        try {
//            EnumSingleton s1 = null;
//            EnumSingleton s2 = EnumSingleton.getInstance();
//            s2.setData(new Object());
//            FileOutputStream fileOutputStream = null;
//            //序列化
//            //获取文件输出流
//            fileOutputStream = new FileOutputStream("EnumSingleton.obj");
//            //获取对象输出流
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//            //把 s2 写入文件
//            objectOutputStream.writeObject(s2);
//            objectOutputStream.flush();
//            objectOutputStream.close();
//
//            //反序列化
//            //获取文件输入流
//            FileInputStream fileInputStream = new FileInputStream("EnumSingleton.obj");
//            //获取对象输入流
//            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//            //读取字节码转换为 Java 对象
//            s1 = (EnumSingleton) objectInputStream.readObject();
//            objectInputStream.close();
//
//            System.out.println(s1.getData());
//            System.out.println(s2.getData());
//            System.out.println(s1.getData() == s2.getData());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    // 测试反射是否能破坏单例
    public static void main(String[] args) {
        //
        try {
            Class clazz = EnumSingleton.class;
            //没有无参构造，需要一个 String 类型和 int 类型的参数
            Constructor c = clazz.getDeclaredConstructor(String.class, int.class);
            c.setAccessible(true);

            EnumSingleton singleton = (EnumSingleton) c.newInstance("Somer", "666");
            //通过查看 newInstance 方法得知，会先判断 class 的 Modify 和判断是否是枚举，如果是枚举就直接报异常（不能反射创建枚举类型）
            //所以，直接从 JDK 层面就约束来枚举不被反序列化破坏和反射破坏。
            System.out.println(singleton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}