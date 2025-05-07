package com.example.libraryapi.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfiguration {
	@Value("${spring.datasource.url}")
	String url;
	@Value("${spring.datasource.username}")
	String username;
	@Value("${spring.datasource.password}")
	String password;
	@Value("${spring.datasource.driver-class-name}")
	String driver;

	@Bean
	public DataSource hikariDataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(url);
		config.setUsername(username);
		config.setPassword(password);
		config.setDriverClassName(driver);

		config.setMaximumPoolSize(10); // maximos de conexoes liberadas
		config.setMinimumIdle(1); // minimo de conexoes liberadas
		config.setPoolName("Library-db-pool");
		config.setMaxLifetime(600000); // 600 mil milesegundos
		config.setConnectionTimeout(100000); // 100 mil milesegundos
		config.setConnectionTestQuery("select 1"); // query teste

		return new HikariDataSource(config);

	}

}
