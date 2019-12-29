package mowei.master1_car.carmanager.services.Imp;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;

@Repository
public  interface BaseImp<T,ID> extends JpaRepository<T,ID> {

}
