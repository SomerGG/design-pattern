package cn.xysomer.create.factory;

import cn.xysomer.create.factory.factorymethod.ShapeFactory;
import cn.xysomer.create.factory.factorymethod.SquareFactory;

/**
 * 工厂方法模式
 */
public class FactoryMethodTest {

    public static void main(String[] args) {
        ShapeFactory factory = new SquareFactory();
        Shape shape = factory.getShape();
        shape.draw();
    }
}
