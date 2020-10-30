package com.kanous.pai_sell.repository;

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
    public List<T> findByString(String[] field, String[] name) {
        StringBuffer stringBuffer = new StringBuffer();
        Query query = null;
        if (field.length > 0 && name.length > 0) {
            String sql = "select u from " + types + " u where ";
            stringBuffer.append(sql);
            for (int i = 0; i < field.length; i++) {
                if (i==0) {
                    stringBuffer.append("u." +field[i] + " = " + "'" + name[i] + "' ");
                } else {
                    stringBuffer.append("and u." +field[i] + " = " + "'" + name[i] + "' ");
                }
            }
        }
        System.out.println(stringBuffer.toString());
        if (stringBuffer.length() > 0) {
            query = entityManager.createQuery(stringBuffer.toString());
        }
        return query.getResultList();
    }
}
