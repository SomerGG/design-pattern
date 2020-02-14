package cn.xysomer.structure.decorator;

/**
 * @Description 装饰器模式测试
 * @Author Somer
 * @Date 2020-02-14 12:31
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Computer computer;
        // 裸机
        computer = new BaseComputer();
        // 加一根内存条
        computer = new MemoryDecorator(computer);
        // 加一块固态
        computer = new SSDDecorator(computer);
        // 再加一根内存条
        computer = new MemoryDecorator(computer);

        System.out.println(computer.getDescription() + "，总价：" + computer.getPrice());
    }
}
