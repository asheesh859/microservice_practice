package com.lcwd.user.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

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

    private List<Rating> rating;

}
