package tr.com.dev.haliYikama.server.test.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
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

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by ramazancesur on 5/23/18.
 */

@Configuration

@EnableJpaRepositories(basePackages = "tr.com.dev.haliYikama.server.persist",
        entityManagerFactoryRef = "testEntityManager",
        transactionManagerRef = "testTransactionManager")
@Profile("testProfile")
public class H2TestProfileJPAConfig {

    @Autowired
    private Environment environment;

    @Bean("testDataSource")
    public DataSource testDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean testEntityManager() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(testDataSource());
        factoryBean.setPackagesToScan("tr.com.dev.haliYikama.server.persist");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.setJpaProperties(getHibernateProperties());
        return factoryBean;
    }

    private Properties getHibernateProperties() {
        Helper helper = new Helper();
        Properties properties = helper.getRestrictProp("application.properties", "hibernate");
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        return properties;
    }


    @Bean
    public PlatformTransactionManager testTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(testEntityManager().getObject());
        DatabasePopulatorUtils.execute(databasePopulatorTestDB(), testDataSource());
        return transactionManager;
    }


    private DatabasePopulator databasePopulatorTestDB() {
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.setContinueOnError(false);
        return databasePopulator;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
