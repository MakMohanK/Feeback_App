package com.makmohank.feedbackapp.config; 
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration; 
import org.springframework.data.jpa.repository.config.EnableJpaRepositories; 
import org.springframework.orm.jpa.JpaTransactionManager; 
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean; 
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter; 
import org.springframework.transaction.PlatformTransactionManager; 
import javax.persistence.EntityManagerFactory; 
import javax.sql.DataSource; 
import org.springframework.boot.jdbc.DataSourceBuilder; 
import org.springframework.beans.factory.annotation.Value; 
import org.springframework.context.annotation.PropertySource; 
import org.springframework.jdbc.datasource.DriverManagerDataSource; 
import java.util.Properties; 
@Configuration 
@EnableJpaRepositories(basePackages = "com.makmohank.feedbackapp.repository") 
@PropertySource("classpath:application.properties") 
public class DatabaseConfig { 
    @Value("${spring.datasource.url}") 
    private String databaseUrl; 
    @Value("${spring.datasource.username}") 
    private String databaseUsername; 
    @Value("${spring.datasource.password}") 
    private String databasePassword; 
    @Bean 
    public DataSource dataSource() { 
        DriverManagerDataSource dataSource = new DriverManagerDataSource(); 
        dataSource.setUrl(databaseUrl); 
        dataSource.setUsername(databaseUsername); 
        dataSource.setPassword(databasePassword); 
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); 
        return dataSource; 
    } 
    @Bean 
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() { 
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean(); 
        em.setDataSource(dataSource()); 
        em.setPackagesToScan("com.makmohank.feedbackapp.model"); 
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter(); 
        em.setJpaVendorAdapter(vendorAdapter); 
        em.setJpaProperties(hibernateProperties()); 
        return em; 
    } 
    @Bean 
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) { 
        JpaTransactionManager transactionManager = new JpaTransactionManager(); 
        transactionManager.setEntityManagerFactory(emf); 
        return transactionManager; 
    } 
    private Properties hibernateProperties() { 
        Properties properties = new Properties(); 
        properties.put("hibernate.hbm2ddl.auto", "update"); 
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect"); 
        properties.put("hibernate.show_sql", "true"); 
        return properties; 
    } 
} 