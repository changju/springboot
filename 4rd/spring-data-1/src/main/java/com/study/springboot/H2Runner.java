package com.study.springboot;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class H2Runner implements ApplicationRunner {
	
	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		//try 해주면 close() 를 해주지 않아도 된다.
		try (Connection connection = dataSource.getConnection()) {
			System.out.println(connection.getMetaData().getURL());
			System.out.println(connection.getMetaData().getUserName());

			Statement statement = connection.createStatement();
			String sql = "create table if not exists USER (ID INTEGER NOT NULL, name VARCHAR(255))";
			statement.executeUpdate(sql);
			// connection.close(); try() 가 있으면 알아서 정리 해준다.
		}
		
		// dataSource 보다는 jdbTemplate 가 더 나은 선택이다.
		// 수행 후 close도 내부적으로 해준다.
		jdbcTemplate.execute("INSERT INTO USER VALUES (1, 'changjulee_H2')");
		
		

	}

}
