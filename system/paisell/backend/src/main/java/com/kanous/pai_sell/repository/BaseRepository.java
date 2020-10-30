package com.kanous.pai_sell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
    boolean support(String type);
    void setTypes(String type);
    List<T> findByString(String[] field, String[] name);
}
