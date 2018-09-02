package com.slandshow.configuration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.slandshow"})
@PropertySource(value = {"classpath:application.properties"})
public class HibernateConfig {
    private static final String MODEL_PACKAGE = "com.slandshow.models";
    private static final String JDBC_DRIVER_CLASS_NAME_PROPERTY = "jdbc.driverClassName";
    private static final String JDBC_URL_PROPERTY = "jdbc.url";
    private static final String HIBERNATE_DIALECT_PROPERTY = "hibernate.dialect";
    private static final String HIBERNATE_SHOW_SQL_PROPERTY = "hibernate.show_sql";
    private static final String HIBERNATE_FORMAT_SQL_PROPERTY = "hibernate.format_sql";


    @Autowired
    private Environment environment;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(MODEL_PACKAGE);
        sessionFactory.setHibernateProperties(hibernateProperties());
        Properties property = new Properties();
        property.put("hibernate.id.new_generator_mappings", "false");
        sessionFactory.setHibernateProperties(property);
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty(JDBC_DRIVER_CLASS_NAME_PROPERTY));
        dataSource.setUrl(environment.getRequiredProperty(JDBC_URL_PROPERTY));
        dataSource.setUsername("root");
        dataSource.setPassword("12345");
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put(HIBERNATE_DIALECT_PROPERTY, environment.getRequiredProperty(HIBERNATE_DIALECT_PROPERTY));
        properties.put(HIBERNATE_SHOW_SQL_PROPERTY, environment.getRequiredProperty(HIBERNATE_SHOW_SQL_PROPERTY));
        properties.put(HIBERNATE_FORMAT_SQL_PROPERTY, environment.getRequiredProperty(HIBERNATE_FORMAT_SQL_PROPERTY));
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }

}
