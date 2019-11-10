package com.fastfoodsm.fastfood.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.fastfoodsm.fastfood.repository"},
        entityManagerFactoryRef = "dbEntityManager",
        transactionManagerRef = "dbTransactionManager")
public class Config {
    @Autowired
    Environment env;

}
