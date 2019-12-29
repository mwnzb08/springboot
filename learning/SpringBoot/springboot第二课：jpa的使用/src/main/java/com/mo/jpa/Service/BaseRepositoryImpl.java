package com.mo.jpa.Service;


import com.mo.jpa.model.Student;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;


@Log4j2
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    private final EntityManager entityManager;
    private final Class<T> domainClass;
    String types;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
//        log.info("?>>>>>>>>>>>>>>domain:{}",domainClass.getName().substring(domainClass.getName().lastIndexOf(".")+1));
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
