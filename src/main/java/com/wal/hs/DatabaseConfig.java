package com.wal.hs;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan("com.wal.hs.crypto.dao.mapper")
public class DatabaseConfig {

	@Autowired
	public DataSource dataSource;

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		PathMatchingResourcePatternResolver pathM3R = new PathMatchingResourcePatternResolver();

		sessionFactory.setMapperLocations(pathM3R.getResources("classpath*:mybatis/*.xml"));
		// sessionFactory.setTypeAliasesPackage("org.lanyonm.playground.domain");
		return sessionFactory.getObject();
	}
}
