package com.mo.mybatis;

import com.mo.mybatis.dao.StudentMapper;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.mo.mybatis.dao")
@Log4j2
public class MybatisApplication implements ApplicationRunner {
    @Autowired
    private StudentMapper studentMapper;

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>:{}",studentMapper.selectByPrimaryKey(1l).toString());
//        log.info(">>>>>>>>>>>>>>>>>>>>>>>:{}",studentMapper.findAll().toString());
//        log.info(">>>>>>>>>>>>>>>>>>>>>>>:{}",studentMapper.findAllByName("wei").toString());
    }
}
