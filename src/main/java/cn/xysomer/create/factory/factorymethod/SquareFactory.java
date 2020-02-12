package cn.xysomer.create.factory.factorymethod;

import cn.xysomer.create.factory.Shape;
import cn.xysomer.create.factory.Square;

public class SquareFactory implements ShapeFactory {

    @Override
    public Shape getShape() {
        return new Square();
    }
}
