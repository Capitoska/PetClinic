package by.bntu.fitr.povt;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.p6spy.engine.spy.P6DataSource;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }

    @Bean
    public DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/pets?true&useSSL=false");
        dataSource.setDatabaseName("pets");
        dataSource.setUser("root");
        dataSource.setPassword("32163216");
        return new P6DataSource(dataSource);
    }

    @Bean
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

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory);
        return hibernateTransactionManager;
    }
}
