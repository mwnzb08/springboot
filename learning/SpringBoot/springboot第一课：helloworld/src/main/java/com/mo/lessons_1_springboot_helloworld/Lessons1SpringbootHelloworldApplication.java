package com.mo.lessons_1_springboot_helloworld;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@SpringBootApplication
@RestController

public class Lessons1SpringbootHelloworldApplication implements ApplicationRunner {
    Logger log = LoggerFactory.getLogger(Logger.class);

    public static void main(String[] args) {
        SpringApplication.run(Lessons1SpringbootHelloworldApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("helloWorld Springboot");
    }

    //
    @RequestMapping(path = "hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String[] hello() {
        String[] result = new String[]{"hill","nice"};
        return result;
    }
}
