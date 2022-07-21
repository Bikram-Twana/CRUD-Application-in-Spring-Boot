package com.example.apidemo.entitiesPackage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Entity

public class Stud {

    @GeneratedValue
    @Id
    private int id;
    @Column(name = "uName")
    private String  userName;
    @Column(name = "fName")
    private String fullName;
    @Column(name = "pass")
    private String password;



}
