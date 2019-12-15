package mowei.master1_car.carmanager.services.apiSercice;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.extern.log4j.Log4j2;
import mowei.master1_car.carmanager.config.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ApiService {
    @Autowired
    private Mapping mapping;
    public Object getFilterData(JSONObject filter){
        String path = filter.getString("path");
        String Model = mapping.Mappings(path);
        filter.forEach((key,value) ->{
            log.info(">>>>>>>>>>>>log {}=={}",key,value);
        });
        return Model;
    }
}
