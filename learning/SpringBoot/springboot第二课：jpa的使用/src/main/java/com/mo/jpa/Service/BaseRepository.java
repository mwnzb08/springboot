package com.mo.jpa.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;


import java.io.Serializable;
import java.util.List;

//添加@NoRepositoryBean，标记为非实例化接口
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
    boolean support(String type);

    void setTypes(String type);

    List<T> findByString(String name);
}
