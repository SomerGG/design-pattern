package cn.xysomer.create.factory;

import cn.xysomer.create.factory.simplefactory.ShapeFactory;

/**
 * 简单工厂模式
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape square = factory.getShape(Square.class);
        square.draw();
    }
}