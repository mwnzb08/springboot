package mowei.master1_car.carmanager.services.carService;

import mowei.master1_car.carmanager.model.car.CarModel;
import mowei.master1_car.carmanager.services.carService.imp.CarImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarImp carImp;
    public List<CarModel> getFilterData(Object carModel){
        List<CarModel> result = new ArrayList<>();
        result = carImp.findAll();
        return result;
    }
}
