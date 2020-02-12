package cn.xysomer.create.factory.factorymethod;

import cn.xysomer.create.factory.Rectangle;
import cn.xysomer.create.factory.Shape;

public class RectangleFactory implements ShapeFactory {

    @Override
    public Shape getShape() {
        return new Rectangle();
    }
}
