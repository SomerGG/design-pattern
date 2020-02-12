package cn.xysomer.create.factory.abstractfactory;

import cn.xysomer.create.factory.Color;
import cn.xysomer.create.factory.Red;
import cn.xysomer.create.factory.Shape;
import cn.xysomer.create.factory.Square;

public class SquareFactory extends AbstractShapeFactory {

    @Override
    public Shape getShape() {
        return new Square();
    }

    @Override
    public Color getColor() {
        return new Red();
    }
}
