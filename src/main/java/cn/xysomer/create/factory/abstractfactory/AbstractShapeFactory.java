package cn.xysomer.create.factory.abstractfactory;

import cn.xysomer.create.factory.Color;
import cn.xysomer.create.factory.Shape;

public abstract class AbstractShapeFactory {

    public abstract Shape getShape();

    public abstract Color getColor();
}
