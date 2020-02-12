package cn.xysomer.create.factory;

import cn.xysomer.create.factory.abstractfactory.AbstractShapeFactory;
import cn.xysomer.create.factory.abstractfactory.SquareFactory;

/**
 * 抽象工厂模式
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        AbstractShapeFactory factory = new SquareFactory();
        factory.getColor().fill();
        factory.getShape().draw();
    }
}
