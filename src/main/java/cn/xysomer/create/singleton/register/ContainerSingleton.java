package cn.xysomer.create.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 容器式单例
 * Spring ioc
 */
public class ContainerSingleton {

    private ContainerSingleton() {

    }

    private static Map<String, Object> ioc = new ConcurrentHashMap<>();

    public static Object getBean(String className) {
        synchronized (ioc) {
            if (!ioc.containsKey(className)) {//不存在，通过简单工厂模式（反射）创建对象并返回
                Object object = null;
                try {
                    object = Class.forName(className).newInstance();
                    ioc.put(className, object);//将生成的对象存入 ioc
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return object;
            }
            return ioc.get(className);//存在，直接从 ioc 中取值
        }
    }
}
