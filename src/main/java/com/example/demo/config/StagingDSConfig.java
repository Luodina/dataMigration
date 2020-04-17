package com.example.demo.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource({"classpath:datasource.properties"})
@EnableJpaRepositories(
	basePackages = "com.example.demo.daostaging",
	entityManagerFactoryRef = "stagingEntityManager",
	transactionManagerRef = "stagingTransactionManager"
)
public class StagingDSConfig {

	@Autowired
    private Environment env;
	
	@Bean
    @Primary
    public DataSource stagingDataSource() {
  
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //dataSource.setDriverClassName(env.getProperty("spring.staging-datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.staging-datasource.url"));
        dataSource.setUsername(env.getProperty("spring.staging-datasource.username"));
        dataSource.setPassword(env.getProperty("spring.staging-datasource.password"));
 
        return dataSource;
    }
     
	
    @Bean("stagingEntityManager")
    @Primary
    public LocalContainerEntityManagerFactoryBean stagingEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(stagingDataSource());
        em.setPackagesToScan(new String[] { "com.example.demo.entitystaging" });
        em.setPersistenceUnitName("Staging@dh-s12c-t02:29801/cimc1d2_dev.cdcoradb11.server.ha.org.hk");
 
        HibernateJpaVendorAdapter vendorAdapter= new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        properties.put("hibernate.physical_naming_strategy", SpringPhysicalNamingStrategy.class.getName());
        properties.put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
        em.setJpaPropertyMap(properties);
        
        return em;
    }
     
 
    @Bean("stagingTransactionManager")
    @Primary
    public PlatformTransactionManager stagingTransactionManager() {
  
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(stagingEntityManager().getObject());
        
        return transactionManager;
    }
	
}
