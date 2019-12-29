package com.mo.jpa.Service.simple;

import com.mo.jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface Studentimpl extends JpaRepository<Student,Long> {
    @Query(value = "update student set name = ?1",nativeQuery = true)
    @Modifying
    @Transactional
    void sql(String sql);
}
