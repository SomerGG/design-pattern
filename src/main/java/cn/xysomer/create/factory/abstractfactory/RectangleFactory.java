package cn.xysomer.create.factory.abstractfactory;

import cn.xysomer.create.factory.Color;
import cn.xysomer.create.factory.Green;
import cn.xysomer.create.factory.Rectangle;
import cn.xysomer.create.factory.Shape;

public class RectangleFactory extends AbstractShapeFactory {

    @Override
    public Shape getShape() {
        return new Rectangle();
    }

    @Override
    public Color getColor() {
        return new Green();
    }
}
