package com.mo.alis.service.system;

import com.mo.alis.service.system.reponsitory.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class BaseService {
    @Autowired
    private List<BaseRepository> baseRepositories;

    @PersistenceContext
    private EntityManager entityManager;


    public BaseRepository mappingDomain(String type) {
        BaseRepository T = null;
        for (BaseRepository baseRepository : baseRepositories) {
            if (baseRepository.support(type)) {//这里是传入一个String用来匹配遍历到那个repository就返回那个repository
                baseRepository.setTypes(type);//这里是用来把当前的repository的名称给固定。这就是之前的两个方法的作用。
                T = baseRepository;
            } else {
                System.out.print("No this Domain or this Domain is not impl baseRepository");
            }
        }
        return T;
    }

    @Transactional
    public List execute(String sql) {
        String prefix = sql.trim().substring(0, sql.trim().indexOf(" "));
        if (prefix.equals("select")) {
            Query query = entityManager.createQuery(sql);
            return query.getResultList();
        } else if (prefix.equals("update") || prefix.equals("delete")) {
            List list = new ArrayList();
            Query query = entityManager.createQuery(sql);
            list.add(query.executeUpdate());
            return list;
        } else {
            List list = new ArrayList();
            list.add("not support");
            return list;
        }
    }
}
