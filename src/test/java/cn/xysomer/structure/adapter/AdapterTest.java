package cn.xysomer.structure.adapter;

/**
 * @Description 适配器测试
 * @Author Somer
 * @Date 2020-02-13 19:42
 */
public class AdapterTest {

    public static void main(String[] args) {
        VlcPlay vlcPlay = new PlayAdapter(new AviFile());
        vlcPlay.play();
    }
}
