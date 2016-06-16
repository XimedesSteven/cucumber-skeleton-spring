package glue.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class GlueDbManager implements InitializingBean {

	@Autowired @Qualifier("dataSource")
	public DataSource dataSource;

	public JdbcTemplate jdbcTemplate;

	@Override
	public void afterPropertiesSet() throws Exception {
		Class.forName("org.h2.Driver");
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void cleanUserTable() {
		jdbcTemplate.update("TRUNCATE TABLE users");
		jdbcTemplate.update("ALTER TABLE users ALTER COLUMN id RESTART WITH 1");
	}

	public void addUser(String name, String email) {
		jdbcTemplate.update("INSERT INTO users(name, email) VALUES (?, ?)", name, email);
	}
}
