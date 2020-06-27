package com.mo.alis.service.system.reponsitory;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    private final EntityManager entityManager;
    private final Class<T> domainClass;
    String types;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
        this.domainClass = domainClass;
    }

    @Override
    public boolean support(String type) {
        return domainClass.getName().substring(domainClass.getName().lastIndexOf(".") + 1).equals(type);
    }

    @Override
    public void setTypes(String type) {
        this.types = type;
    }

    @Override
    public List<T> findByString(String name) {
        String sql = "select u from " + types + " u where u.name = " + "'" + name + "'";
        Query query = entityManager.createQuery(sql);
        return query.getResultList();
    }
}
