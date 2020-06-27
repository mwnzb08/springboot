package com.mo.alis.service.system.reponsitory;

import com.mo.alis.model.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends BaseRepository<User,Long>{
    List<User> findAllByUserAccountAndUserPassword(String account,String pwd);
    @Query("select id from User where userAccount = ?1")
    Long findIdByUserAccount(String account);
}

