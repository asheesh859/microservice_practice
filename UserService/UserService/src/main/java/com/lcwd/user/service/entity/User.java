package com.lcwd.user.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name="ID")
    private String userID;

    @Column(name = "Name")
    private String name;

    @Column(name = "EMAIl")
    private String email;

    @Column(name = "ABOUT")
    private String about;

}
