package cn.xysomer.create.singleton;

import cn.xysomer.create.singleton.register.ContainerSingleton;

public class ContainerSingletonTest {

    public static void main(String[] args) {
        try {
            ConcurrentExecutor.execute(new ConcurrentExecutor.RunHandler() {
                @Override
                public void handler() {
                    Object object = ContainerSingleton.getBean("cn.xysomer.create.singleton.Pojo");
                    System.out.println(object);
                }
            }, 10, 6);
            //对象方便管理，也是属于懒加载，但是存在线程安全问题
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
