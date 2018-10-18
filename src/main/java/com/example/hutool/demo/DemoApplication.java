package com.example.hutool.demo;

import cn.hutool.db.Entity;
import cn.hutool.db.SqlConnRunner;
import cn.hutool.db.SqlRunner;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

	@Bean("dataSource")
	public DataSource getDataSource(){
		DruidDataSource ds2 = new DruidDataSource();
		ds2.setUrl("jdbc:mysql://192.168.1.160:3306/chushi_oappmerchant?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true");
		ds2.setUsername("btob");
		ds2.setPassword("1qaz@WSX");
		return ds2;
	}

	@Resource
	public DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/hello")
	public List<Entity> hello(){
		SqlConnRunner runner = SqlConnRunner.create(dataSource);
		List<Entity> order_base = null;
		try {
			order_base = runner.findAll(dataSource.getConnection(), "order_base");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return order_base;
	}
}
