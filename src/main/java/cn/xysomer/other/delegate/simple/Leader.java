package cn.xysomer.other.delegate.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 项目经理
 * @Author Somer
 * @Date 2020-02-13 11:39
 */
public class Leader {

    //知道每个员工擅长的领域
    private static final Map<String, IEmployee> EMPLOYEE = new HashMap<>();

    public Leader() {
        EMPLOYEE.put("加密", new EmployeeA());
        EMPLOYEE.put("架构", new EmployeeB());
    }

    public void doing(String task) {
        EMPLOYEE.get(task).doing(task);
    }
}
