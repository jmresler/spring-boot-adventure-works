package org.jmresler.studies.kanban.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "org.jmresler.studies.kanban.domain.batch",
        entityManagerFactoryRef = "h2EntityManager",
        transactionManagerRef = "h2TransactionManager"
)
public class H2SqlConfiguration {

    @Value("${spring.datasource.batch.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.batch.url}")
    private String jdbcUrl;
    @Value("${spring.datasource.batch.username}")
    private String userName;
    @Value("${spring.datasource.batch.password}")
    private String password;

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean h2EntityManager() {
        var em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(h2SqlDatasource());
        em.setPackagesToScan("org.jmresler.studies.kanban.domain.batch");
        var vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        return em;
    }

    @Primary
    @Bean
    public DataSource h2SqlDatasource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .url(jdbcUrl)
                .driverClassName(driverClassName)
                .username(userName)
                .password(password)
                .build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager h2TransactionManager() {
        var transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(h2EntityManager().getObject());
        return transactionManager;
    }

}
