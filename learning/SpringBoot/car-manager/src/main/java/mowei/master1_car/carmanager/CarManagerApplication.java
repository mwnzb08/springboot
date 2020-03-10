package mowei.master1_car.carmanager;


import mowei.master1_car.carmanager.config.jpaConfig.BaseJpaRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = BaseJpaRepositoryFactoryBean.class)
public class CarManagerApplication {
    public static void main(String[] args) { SpringApplication.run(CarManagerApplication.class, args);
    }
}
