package com.mo.alis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "a_little_store")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "user_name", nullable = false, length = 20)
    private String userName;
    @Column(name = "user_account", nullable = false, length = 20)
    private String userAccount;
    @Column(name = "user_password", nullable = false, length = 300)
    private String userPassword;
    @Column(name = "remarks", nullable = true, length = 255)
    private String remarks;
    private Timestamp createTime;
    private Timestamp updateTime;
}
