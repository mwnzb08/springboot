package mowei.master1_car.carmanager.controller.ApiController;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import mowei.master1_car.carmanager.model.car.CarModel;
import mowei.master1_car.carmanager.services.apiSercice.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api")
@Log4j2
public class ApiController {
    @Autowired
    private ApiService apiService;

    @PostMapping(path = "/filter")
    public String filter() {
        return "11";
    }
    @GetMapping(path = "test")
    public String test() {
        log.warn("input>>>>>>>>>filters");
        return "1111";
    }
}
