package org.jmresler.studies.kanban.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "org.jmresler.studies.kanban.domain.aw",
        entityManagerFactoryRef = "mssqlEntityManager",
        transactionManagerRef = "mssqlTransactionManager"
)
public class MsSqlConfiguration {

    @Value("${spring.datasource.aw.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.aw.url}")
    private String jdbcUrl;
    @Value("${spring.datasource.aw.username}")
    private String userName;
    @Value("${spring.datasource.aw.password}")
    private String password;

    @Bean
    public LocalContainerEntityManagerFactoryBean mssqlEntityManager() {
        var em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(msSqlDatasource());
        em.setPackagesToScan("org.jmresler.studies.kanban.domain.aw");
        var vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        return em;
    }

    @Bean
    public DataSource msSqlDatasource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .url(jdbcUrl)
                .driverClassName(driverClassName)
                .username(userName)
                .password(password)
                .build();
    }

    @Bean
    public PlatformTransactionManager mssqlTransactionManager() {
        var transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(mssqlEntityManager().getObject());
        return transactionManager;
    }

}
