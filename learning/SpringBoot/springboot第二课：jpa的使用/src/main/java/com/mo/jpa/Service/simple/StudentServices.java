package com.mo.jpa.Service.simple;

import com.mo.jpa.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices {
    @Autowired
    private Studentimpl studentimpl;

    public void save(Student student){
        studentimpl.saveAndFlush(student);
    }
    public void deleteById(Long id) {
        studentimpl.deleteById(id);
    }
    public void Updated(String name){
        studentimpl.sql(name);
    }
    public List<Student> getAll(){
        return studentimpl.findAll();
    }

}
