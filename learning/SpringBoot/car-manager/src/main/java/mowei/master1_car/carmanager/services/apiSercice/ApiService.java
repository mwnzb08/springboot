package mowei.master1_car.carmanager.services.apiSercice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import mowei.master1_car.carmanager.model.car.CarModel;
import mowei.master1_car.carmanager.services.Imp.BaseImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ApiService {
    @Autowired
    private BaseImp<CarModel,Long> baseImp;
    public String getFilterData(JSONObject jsonObject){
        String path = jsonObject.getString("path");
        return JSON.toJSONString(baseImp.findAll());
    }
}
