package com.vermisse.boot;

import javax.sql.*;

import org.apache.commons.dbcp.*;
import org.apache.ibatis.session.*;
import org.mybatis.spring.*;
import org.mybatis.spring.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.context.properties.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.*;
import org.springframework.jdbc.datasource.*;
import org.springframework.transaction.*;

@Configuration
// 扫描Dao接口所在包，如果有多个用逗号隔开
@MapperScan("com.vermisse.boot.dao")
public class Database {

	@Autowired
	private Environment env;

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "datasource.primary")
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
		ds.setUrl(env.getProperty("spring.datasource.url"));
		ds.setUsername(env.getProperty("spring.datasource.username"));
		ds.setPassword(env.getProperty("spring.datasource.password"));
		return ds;
	}

	@Bean
	public PlatformTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());

		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:com/vermisse/boot/dao/mapper/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}
}