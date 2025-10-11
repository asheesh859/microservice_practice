package com.lcwd.user.service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="micro_user")
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

    @Transient
    private List<Rating> rating = new ArrayList<>();

}
