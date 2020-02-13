package cn.xysomer.structure.adapter;

/**
 * @Description 播放适配器
 * @Author Somer
 * @Date 2020-02-13 19:01
 */
public class PlayAdapter implements VlcPlay {

    AviFile aviFile;

    public PlayAdapter(AviFile aviFile) {
        this.aviFile = aviFile;
    }

    @Override
    public String play() {
        String avi = aviFile.play();
        //执行适配
        System.out.println("执行适配......");
        System.out.println("格式已通过适配器转换完成");
        String adapterOut = "vlc";
        System.out.println("使用媒体适配器，收到文件格式：" + avi + "，播放格式为：" + adapterOut);
        return adapterOut;
    }
}
