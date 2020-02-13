package cn.xysomer.other.delegate;

import cn.xysomer.other.delegate.simple.Boss;
import cn.xysomer.other.delegate.simple.Leader;

/**
 * @Description 委派模式测试
 * @Author Somer
 * @Date 2020-02-13 11:44
 */
public class DelegateTest {

    public static void main(String[] args) {
        new Boss().doing("加密", new Leader());
    }
}
