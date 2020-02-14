package cn.xysomer.structure.decorator;

/**
 * @Description 电脑基本信息
 * @Author Somer
 * @Date 2020-02-14 12:19
 */
public class BaseComputer extends Computer {

    @Override
    protected String getDescription() {
        return "裸机电脑";
    }

    @Override
    protected int getPrice() {
        return 3000;
    }
}
