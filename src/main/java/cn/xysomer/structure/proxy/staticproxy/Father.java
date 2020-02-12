package cn.xysomer.structure.proxy.staticproxy;

public class Father {

    private Son son;

    public Father(Son son) {
        this.son = son;
    }

    //目标对象的引用给拿到
    public void findLove() {
        System.out.println("父母帮忙物色对象");
        this.son.findLove();
        System.out.println("找到对象了");
    }
}
