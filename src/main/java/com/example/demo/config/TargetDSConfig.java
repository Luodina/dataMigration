package com.example.demo.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
	basePackages = "com.example.demo.daotarget",
	entityManagerFactoryRef = "targetEntityManager",
	transactionManagerRef = "targetTransactionManager"
  
)
public class TargetDSConfig {

	@Autowired
    private Environment env;
	
	@Bean
    public DataSource targetDataSource() {
  
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //dataSource.setDriverClassName(env.getProperty("spring.target-datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.target-datasource.url"));
        dataSource.setUsername(env.getProperty("spring.target-datasource.username"));
        dataSource.setPassword(env.getProperty("spring.target-datasource.password"));
 
        return dataSource;
    }
 
	
    @Bean("targetEntityManager")
    public LocalContainerEntityManagerFactoryBean targetEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(targetDataSource());
        em.setPackagesToScan(new String[] { "com.example.demo.entitytarget" });
        em.setPersistenceUnitName("Target@cimvmc1a:19306/cimc1d2.cdcoradb11.server.ha.org.hk");
 
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        properties.put("hibernate.physical_naming_strategy", SpringPhysicalNamingStrategy.class.getName());
        properties.put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
        em.setJpaPropertyMap(properties);
 
        return em;
    }
     
 
    @Bean("targetTransactionManager")
    public PlatformTransactionManager targetTransactionManager() {
  
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(targetEntityManager().getObject());
        
        return transactionManager;
    }
	
}
