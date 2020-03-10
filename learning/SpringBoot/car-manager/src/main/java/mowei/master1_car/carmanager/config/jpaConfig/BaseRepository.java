package mowei.master1_car.carmanager.config.jpaConfig;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
    boolean matchDomain(String type);

    void domain(String type);
}
