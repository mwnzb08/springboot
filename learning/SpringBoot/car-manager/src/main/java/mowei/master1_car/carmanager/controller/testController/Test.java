package mowei.master1_car.carmanager.controller.testController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "test")
public class Test {
    @GetMapping(path = "/helloWorld")
    public String test(){

        return "helloWorld";
    }
}
