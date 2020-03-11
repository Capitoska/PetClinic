package by.bntu.fitr.povt.config;

import by.bntu.fitr.povt.util.MySQLDatabaseCreator;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.p6spy.engine.spy.P6DataSource;
import lombok.Setter;
import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ConfigurationProperties(prefix = "database")
@Setter
public class DatabaseConfig {

    private String url;
    private String dbName;
    private String user;
    private String password;
    private String driver;


    @Bean(initMethod = "createDatabaseIfNotExists")
    public MySQLDatabaseCreator mySQLDatabaseCreator() {
        MySQLDatabaseCreator creator = new MySQLDatabaseCreator();
        creator.setCharacter("utf8mb4");
        creator.setCollate("utf8mb4_general_ci");
        creator.setUrl(url);
        creator.setPass(password);
        creator.setUser(user);
        creator.setDriver(driver);
        return creator;
    }


    @Bean
    public DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(url);
        dataSource.setDatabaseName(dbName);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return new P6DataSource(dataSource);
    }


    @Bean
    @DependsOn("flyway")
    public LocalSessionFactoryBean sessionFactory(DataSource source) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(source);
        sessionFactory.setPackagesToScan("by.bntu.fitr.povt.model");

        Properties prop = new Properties();
        prop.setProperty("hibernate.hbm2ddl.auto", "validate");
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL55Dialect");

        prop.setProperty("hibernate.show_sql", "false");
        prop.setProperty("hibernate.format_sql", "false");
        prop.setProperty("hibernate.use_sql_comments", "false");
        prop.setProperty("hibernate.generate_statistics", "false");
        prop.setProperty("hibernate.jdbc.batch_size", "20");

        sessionFactory.setHibernateProperties(prop);
        return sessionFactory;
    }

    @DependsOn("mySQLDatabaseCreator")
    @Bean(initMethod = "migrate")
    public Flyway flyway(DataSource dataSource) {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.setBaselineOnMigrate(true);
        flyway.setLocations("classpath:db/migration");
        flyway.setEncoding("UTF-8");
        return flyway;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory);
        return hibernateTransactionManager;
    }
}
