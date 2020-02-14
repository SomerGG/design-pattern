package cn.xysomer.structure.decorator;

/**
 * @Description 添加固态硬盘
 * @Author Somer
 * @Date 2020-02-14 12:29
 */
public class SSDDecorator extends ComputerDecorator {

    public SSDDecorator(Computer computer) {
        super(computer);
    }

    @Override
    protected String getDescription() {
        return super.getDescription() + " + 1块512G固态硬盘";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 400;
    }
}
