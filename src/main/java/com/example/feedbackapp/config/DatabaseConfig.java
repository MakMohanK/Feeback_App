package com.example.feedbackapp.config; 
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration; 
import org.springframework.data.jpa.repository.config.EnableJpaRepositories; 
import org.springframework.orm.jpa.JpaTransactionManager; 
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean; 
import org.springframework.transaction.PlatformTransactionManager; 
import org.springframework.transaction.annotation.EnableTransactionManagement; 
import javax.persistence.EntityManagerFactory; 
import javax.sql.DataSource; 
import org.springframework.boot.jdbc.DataSourceBuilder; 
import org.springframework.beans.factory.annotation.Value; 
import org.springframework.context.annotation.PropertySource; 
import org.springframework.jdbc.datasource.DriverManagerDataSource; 
import java.util.logging.Logger; 
@Configuration 
@EnableJpaRepositories(basePackages = "com.example.feedbackapp.repository") 
@EnableTransactionManagement 
@PropertySource("classpath:application.properties") 
public class DatabaseConfig { 
    private static final Logger logger = Logger.getLogger(DatabaseConfig.class.getName()); 
    @Value("${spring.datasource.url}") 
    private String databaseUrl; 
    @Value("${spring.datasource.username}") 
    private String databaseUsername; 
    @Value("${spring.datasource.password}") 
    private String databasePassword; 
    @Bean 
    public DataSource dataSource() { 
        try { 
            logger.info("Configuring the DataSource."); 
            DriverManagerDataSource dataSource = new DriverManagerDataSource(); 
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); 
            dataSource.setUrl(databaseUrl); 
            dataSource.setUsername(databaseUsername); 
            dataSource.setPassword(databasePassword); 
            logger.info("DataSource configured successfully."); 
            return dataSource; 
        } catch (Exception e) { 
            logger.severe("Error configuring DataSource: " + e.getMessage()); 
            throw new RuntimeException("Failed to configure DataSource", e); 
        } 
    } 
    @Bean 
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) { 
        try { 
            logger.info("Setting up EntityManagerFactory."); 
            LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean(); 
            em.setDataSource(dataSource); 
            em.setPackagesToScan("com.example.feedbackapp.model"); 
            logger.info("EntityManagerFactory set up successfully."); 
            return em; 
        } catch (Exception e) { 
            logger.severe("Error setting up EntityManagerFactory: " + e.getMessage()); 
            throw new RuntimeException("Failed to set up EntityManagerFactory", e); 
        } 
    } 
    @Bean 
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) { 
        try { 
            logger.info("Configuring TransactionManager."); 
            JpaTransactionManager transactionManager = new JpaTransactionManager(); 
            transactionManager.setEntityManagerFactory(emf); 
            logger.info("TransactionManager configured successfully."); 
            return transactionManager; 
        } catch (Exception e) { 
            logger.severe("Error configuring TransactionManager: " + e.getMessage()); 
            throw new RuntimeException("Failed to configure TransactionManager", e); 
        } 
    } 
} 