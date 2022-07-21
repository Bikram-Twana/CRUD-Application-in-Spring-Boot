package com.example.apidemo.repository;

import com.example.apidemo.entitiesPackage.Stud;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentRepository extends JpaRepository<Stud,Integer> {

    Stud findByUserName(String name);
}
