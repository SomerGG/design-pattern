package cn.xysomer.structure.proxy.staticproxy;

/**
 * @Description 动态切换数据源
 * @Author Somer
 * @Date 2020-02-12 15:53
 */
public class DynamicDataSourceEntry {

    private final static String DEFAULT_SOURCE = null;

    private final static ThreadLocal<String> LOCAL = new ThreadLocal<>();

    private DynamicDataSourceEntry(){

    }

    //清空数据源
    public static void clear() {
        LOCAL.remove();
    }

    //获取正在使用的数据源
    public static String get() {
        return LOCAL.get();
    }

    //还原当前切面的数据源
    public static void restore() {
        LOCAL.set(DEFAULT_SOURCE);
    }

    //根据年份动态设置数据源
    public static void set(int year) {
        LOCAL.set("DB_" + year);
    }
}
