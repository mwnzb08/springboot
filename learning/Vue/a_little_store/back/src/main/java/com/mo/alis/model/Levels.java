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
@Table(name = "levels", schema = "a_little_store")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Levels implements Serializable {
    @Id
    @Column(name = "uid", nullable = false)
    private long uid;
    @Column(name = "picture", nullable = true, length = 255)
    private String picture;
    @Column(name = "levels", nullable = false)
    private byte levels;
    @Column(name = "grades", nullable = false)
    private int grades;
    @Column(name = "remakes", nullable = true, length = 255)
    private String remakes;
    @Column(name = "create_time", nullable = true)
    private Timestamp createTime;
    @Column(name = "update_time", nullable = true)
    private Timestamp updateTime;
}
