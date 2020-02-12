package cn.xysomer.create.singleton;

import cn.xysomer.create.singleton.serializable.SerializableSingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableSingletonTest {

    //将新建的对象 s2 序列化，反序列化的时候重新创建
    public static void main(String[] args) {
        SerializableSingleton s1 = null;
        SerializableSingleton s2 = SerializableSingleton.getInstance();
        FileOutputStream fileOutputStream = null;
        try {
            //序列化
            //获取文件输出流
            fileOutputStream = new FileOutputStream("SerializableSingleton.obj");
            //获取对象输出流
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            //把 s2 写入文件
            objectOutputStream.writeObject(s2);
            objectOutputStream.flush();
            objectOutputStream.close();

            //反序列化
            //获取文件输入流
            FileInputStream fileInputStream = new FileInputStream("SerializableSingleton.obj");
            //获取对象输入流
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            //读取字节码转换为 Java 对象
            s1 = (SerializableSingleton) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}