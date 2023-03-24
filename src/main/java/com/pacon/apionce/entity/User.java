package com.pacon.apionce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue
    @Column
    private int userId;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String mobile;
    @Column
    private String gender;
    @Column
    private int age;
    @Column
    private String nationality;

}
