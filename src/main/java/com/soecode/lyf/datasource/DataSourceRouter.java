package com.soecode.lyf.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Description
 * @Author DJZ-WWS
 * 实现spring多路配置，由spring管理
 * @Date 2019/6/2 16:14
 */
public class DataSourceRouter   extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return HandleDataSource.getDataSource();
    }
}
