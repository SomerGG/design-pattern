package cn.xysomer.structure.decorator;

/**
 * @Description 电脑的抽象装饰器
 * @Author Somer
 * @Date 2020-02-14 12:23
 */
public abstract class ComputerDecorator extends Computer {

    // 静态代理、委派
    private Computer computer;

    public ComputerDecorator(Computer computer) {
        this.computer = computer;
    }

    @Override
    protected String getDescription() {
        return this.computer.getDescription();
    }

    @Override
    protected int getPrice() {
        return this.computer.getPrice();
    }
}
