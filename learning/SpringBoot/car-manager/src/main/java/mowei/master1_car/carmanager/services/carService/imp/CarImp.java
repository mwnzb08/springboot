package mowei.master1_car.carmanager.services.carService.imp;

import mowei.master1_car.carmanager.model.car.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarImp extends JpaRepository<CarModel,Long> {
}
