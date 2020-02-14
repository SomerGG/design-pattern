package cn.xysomer.behavior.observe;

/**
 * @Description 具体的观察者对象
 * @Author Somer
 * @Date 2020-02-14 14:47
 */
public class ObserverUser implements IObserver {

    private String username;//观察者姓名

    public ObserverUser(String username) {
        this.username = username;
    }

    @Override
    public void update(String message) {
        System.out.println(this.username + " 收到一条消息，内容是：" + message);
    }
}
