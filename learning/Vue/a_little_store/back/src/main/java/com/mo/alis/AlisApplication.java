package com.mo.alis;

import com.mo.alis.service.system.reponsitory.BaseRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
public class AlisApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlisApplication.class, args);
    }

}
