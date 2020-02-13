package cn.xysomer.other.delegate.simple;

/**
 * @Description 员工A
 * @Author Somer
 * @Date 2020-02-13 11:36
 */
public class EmployeeA implements IEmployee {

    @Override
    public void doing(String task) {
        System.out.println("我是员工A，擅长加密，接到" + task + "任务，开始干活");
    }
}
