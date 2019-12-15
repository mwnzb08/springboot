package mowei.master1_car.carmanager.controller.ApiController;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import mowei.master1_car.carmanager.services.apiSercice.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api")
@Log4j2
public class ApiController {
    @Autowired
    private ApiService apiService;

    @PostMapping(path = "filter",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object filter(@RequestBody JSONObject listen) {
        log.info("input>>>>>>>>>filters:  {}",listen);
        return apiService.getFilterData(listen);
    }

}
