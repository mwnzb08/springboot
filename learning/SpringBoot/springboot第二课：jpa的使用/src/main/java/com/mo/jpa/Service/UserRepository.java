package com.mo.jpa.Service;

import com.mo.jpa.model.Student;
import org.springframework.data.domain.DomainEvents;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserRepository extends BaseRepository<Student, Long> {
    Student findAllByName(String name);
}
