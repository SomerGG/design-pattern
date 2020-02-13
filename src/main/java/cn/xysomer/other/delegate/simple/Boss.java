package cn.xysomer.other.delegate.simple;

/**
 * @Description 老板
 * @Author Somer
 * @Date 2020-02-13 11:43
 */
public class Boss {

    public void doing(String task, Leader leader) {
        leader.doing(task);
    }
}
