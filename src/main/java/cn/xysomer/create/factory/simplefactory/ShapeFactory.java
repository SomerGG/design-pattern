package cn.xysomer.create.factory.simplefactory;

import cn.xysomer.create.factory.Shape;

/**
 * 工厂，提供各种对象的实例
 *
 */
public class ShapeFactory {

    public Shape getShape(Class clazz) {
        try {
            if (null != clazz) {
                return (Shape) clazz.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
