package learning.db.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author NAgafonov
 */
@Configuration
public class ApplicationConfig {

    @Bean
    public HikariConfig hikariconfig() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        hikariConfig.setUsername("postgres");
        hikariConfig.setPassword("password");
        hikariConfig.setConnectionTimeout(50000);
        hikariConfig.setMaximumPoolSize(100);
        return hikariConfig;
    }

    @Bean
    public DataSource hikariDataSource(HikariConfig config) {
        return new HikariDataSource(config);
    }
}
