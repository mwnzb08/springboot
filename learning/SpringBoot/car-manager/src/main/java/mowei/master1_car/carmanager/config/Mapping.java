package mowei.master1_car.carmanager.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Log4j2
@Component
public class Mapping {
    @Value("classpath:mowei/master1_car/carmanager/config/PathMappingModel")
    private Resource resource;

    public String Mappings(String path){
        try{
            BufferedReader s  = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            if (s.readLine().equals(path)){
                return s.readLine();
            }
            return s.readLine();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
