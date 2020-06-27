package com.mo.alis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "view_find_user_money_levels", schema = "a_little_store")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ViewFindUserMoneyLevels {
    @Id
    @Column(name = "uid", nullable = false)
    private long uid;
    @Column(name = "money", nullable = false)
    private int money;
    @Column(name = "picture", nullable = true, length = 255)
    private String picture;
    @Column(name = "levels", nullable = false)
    private byte levels;
    @Column(name = "grades", nullable = false)
    private int grades;
    @Column(name = "remakes", nullable = true, length = 255)
    private String remakes;
}
