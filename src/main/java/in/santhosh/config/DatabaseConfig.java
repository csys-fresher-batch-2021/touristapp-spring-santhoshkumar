package in.santhosh.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import in.santhosh.util.ConnectionUtil;

@Configuration
public class DatabaseConfig {

	@Bean
	public JdbcTemplate jdbcTemplate() {
		DataSource jdbcTemplate = ConnectionUtil.getConnection();
		return new JdbcTemplate(jdbcTemplate);
	}
 
}