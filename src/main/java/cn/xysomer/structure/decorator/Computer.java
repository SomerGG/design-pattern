package cn.xysomer.structure.decorator;

/**
 * @Description 电脑基本描述
 * @Author Somer
 * @Date 2020-02-14 12:17
 */
public abstract class Computer {

    /**
     * 信息描述
     */
    protected abstract String getDescription();

    /**
     * 价格
     */
    protected abstract int getPrice();
}
