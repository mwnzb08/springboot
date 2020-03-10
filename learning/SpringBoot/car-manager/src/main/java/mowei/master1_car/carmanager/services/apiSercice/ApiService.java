package mowei.master1_car.carmanager.services.apiSercice;

import lombok.extern.log4j.Log4j2;
import mowei.master1_car.carmanager.config.jpaConfig.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class ApiService {

    @Autowired
    private List<BaseRepository> baseRepositories;//自动的会把所有的继承了BaseRepository的repository都注入进来

    @PersistenceContext
    private EntityManager entityManager;

    public BaseRepository mappingDomain(String type) {
        BaseRepository T = null;
        for (BaseRepository baseRepository : baseRepositories) {
            if (baseRepository.matchDomain(type)) {//这里是传入一个String用来匹配遍历到那个repository就返回那个repository
                baseRepository.domain(type);//这里是用来把当前的repository的名称给固定。这就是之前的两个方法的作用。
                T = baseRepository;
            }
        }
        return T;
    }

    @Transactional
    public List execute(String sql) {
        String prefix = sql.trim().substring(0, sql.trim().indexOf(" "));
        log.info(">>>{}", prefix);
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
