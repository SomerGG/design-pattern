package cn.xysomer.structure.decorator;

/**
 * @Description 扩展内存条
 * @Author Somer
 * @Date 2020-02-14 12:27
 */
public class MemoryDecorator extends ComputerDecorator {

    public MemoryDecorator(Computer computer) {
        super(computer);
    }

    @Override
    protected String getDescription() {
        return super.getDescription() + " + 1根8G内存条";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 300;
    }
}
