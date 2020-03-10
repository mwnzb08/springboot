package mowei.master1_car.carmanager.config.jpaConfig;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class BaseServiceImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    private Class<T> domainClass;
    private EntityManager entityManager;
    private String types;

    public BaseServiceImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.domainClass = domainClass;
        this.entityManager = entityManager;
    }

    @Override
    public boolean matchDomain(String type) {
        return domainClass.getName().substring(domainClass.getName().lastIndexOf(".") + 1).equals(type);
    }

    @Override
    public void domain(String type) {
        this.types = type;
    }
}
