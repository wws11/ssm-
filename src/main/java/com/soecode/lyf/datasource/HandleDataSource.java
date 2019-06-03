package com.soecode.lyf.datasource;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/6/2 16:16
 */
public class HandleDataSource {
    // 数据源名称线程池
    private static final ThreadLocal<String> holder = new ThreadLocal<>();

    /**
     * 设置数据源
     * @param datasource 数据源名称
     */
    public static void setDataSource(String datasource) {
        holder.set(datasource);
    }
    /**
     * 获取数据源
     * @return 数据源名称
     */
    public static String getDataSource() {
        return holder.get();
    }
    /**
     * 清空数据源
     */
    public static void clearDataSource() {
        holder.remove();
    }
}
