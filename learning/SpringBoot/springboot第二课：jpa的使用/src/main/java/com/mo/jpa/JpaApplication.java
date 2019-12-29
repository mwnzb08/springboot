package com.mo.jpa;

import com.mo.jpa.Service.*;
//import com.mo.jpa.Service.BaseRepository;
import com.mo.jpa.Service.simple.StudentServices;
import com.mo.jpa.model.Student;
import com.mo.jpa.model.Teacher;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
@Log4j2
public class JpaApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Autowired
    private StudentServices studentServices;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BaseService baseService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        studentServices.save(Student.builder().name("mo").sex("man").build());//保存一个数据
        log.info(">>>>>>>>>>>1>>>>{}", studentServices.getAll());//获取保存的数据
        log.info(">>>>>>>>>>>>>>>2{}", userRepository.findAllByName("mo"));//使用Name获取数据
        studentServices.Updated("wei");//更新数据的name字段
        log.info(">>>>>>>>>>>>>>>3{}", studentServices.getAll());
//        studentServices.deleteById(1l);//更据Id删除数据
//        log.info(">>>>>>>>>>>4{}",studentServices.getAll());
        log.info(">>>>>>>>>>>>>>>5{}", userRepository.findAll());
        log.info(">>>>>>>>>>>>>>>6{}", baseService.mappingDomain("Student").findAll());//根据传进去的String获取repository
        log.info(">>>>>>>>>>>>>>>7{}", baseService.mappingDomain("Student").findByString("wei"));
        baseService.mappingDomain("Teacher").saveAndFlush(Teacher.builder().name("momo").sex("women").build());//
        baseService.mappingDomain("Teacher").saveAndFlush(Teacher.builder().name("molin").sex("women").build());
        log.info(">>>>>>>>>>>>>>>7{}", baseService.mappingDomain("Teacher").findByString("momo"));
        log.info(">>>>>>>>>>>>>>8:{}", baseService.execute("select u from Teacher u "));
        log.info(">>>>>>>>>>>>>>9:{}", baseService.execute("update Teacher u set u.name = 'linyin' where u.name = 'momo'"));
        log.info(">>>>>>>>>>>>>10:{}", baseService.execute("select u from Teacher u "));
        log.info(">>>>>>>>>>>>>10:{}", baseService.execute("delete from Teacher u where u.name = 'moli'"));
        log.info(">>>>>>>>>>>>>10:{}", baseService.execute("select u from Teacher u "));
        log.info(">>>>>>>>>>>>>10:{}", baseService.execute("insert into'"));
    }
}
