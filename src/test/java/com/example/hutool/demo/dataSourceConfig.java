package com.example.hutool.demo;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class dataSourceConfig {

    @Bean("dataSource")
    public DataSource getDataSource(){
        DruidDataSource ds2 = new DruidDataSource();
        ds2.setUrl("jdbc:mysql://192.168.1.160:3306/chushi_oappmerchant?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true");
        ds2.setUsername("btob");
        ds2.setPassword("1qaz@WSX");
        return ds2;
    }
}
