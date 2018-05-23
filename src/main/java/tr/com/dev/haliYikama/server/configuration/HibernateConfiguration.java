package tr.com.dev.haliYikama.server.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import tr.com.dev.haliYikama.server.helper.Helper;

import java.util.Properties;

/**
 * Created by ramazancesur on 5/19/18.
 */

@Configuration
@EnableJpaRepositories(basePackages = "tr.com.dev.haliYikama.server.persist",
        entityManagerFactoryRef = "protEntityManager",
        transactionManagerRef = "protTransactionManager")
@ImportResource("classpath:application.properties")
public class HibernateConfiguration {
    @Autowired
    private Environment environment;

    @Bean("dataSource")
    @Primary
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }


    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean protEntityManager() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("tr.com.dev.haliYikama.server.persist");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.setJpaProperties(getHibernateProperties());
        return factoryBean;
    }

    private Properties getHibernateProperties() {
        Helper helper= new Helper();
        Properties properties= helper.getRestrictProp("application.properties","hibernate");
        //properties.put("hibernate.dialect", environment.getRequiredProperty("spring.datasource.h2.dialect"));
        return properties;
    }


    @Bean
    @Primary
    public PlatformTransactionManager protTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(protEntityManager().getObject());
        DatabasePopulatorUtils.execute(databasePopulatorh2(),dataSource());
        return transactionManager;
    }


    private DatabasePopulator databasePopulatorh2() {
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.setContinueOnError(false);
        return databasePopulator;
    }

    @Bean
    @Primary
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }



}
