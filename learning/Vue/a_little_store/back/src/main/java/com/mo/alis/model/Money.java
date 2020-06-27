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
@Table(name = "money", schema = "a_little_store")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Money implements Serializable {
    @Id
    @Column(name = "uid", nullable = false)
    private long uid;
    @Column(name = "money", nullable = false)
    private int money;
    @Column(name = "remakes", nullable = true, length = 255)
    private String remakes;
    @Column(name = "create_time", nullable = true)
    private Timestamp createTime;
    @Column(name = "update_time", nullable = true)
    private Timestamp updateTime;
}
