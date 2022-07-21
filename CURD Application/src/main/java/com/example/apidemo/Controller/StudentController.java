package com.example.apidemo.Controller;

import com.example.apidemo.PasswordHashing.PasswordHashingClass;
import com.example.apidemo.Service.UserService;
import com.example.apidemo.entitiesPackage.Stud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("api/v1/addStudent")
    public Stud addStudent(@RequestBody Stud stud){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(stud.getPassword());
        stud.setPassword(encodedPassword);
        return userService.saveStudent(stud);
    }

    @PostMapping("api/v1/addStudents")
    public List<Stud> addStudents(@RequestBody List<Stud> studs ){
        return userService.saveStudents(studs);
    }

    @GetMapping("api/v1/getStudents")
    public List<Stud> getStudents(){
        return userService.getStudents();
    }

    @GetMapping("api/v1/getstudentsById/{id}")
    public Stud getStudentsById(@PathVariable int id){
        return userService.getStudentsById(id);
    }

    @GetMapping("api/v1/getstudentsByName/{name}")
    public Stud findByUserName(@PathVariable String name){
        return userService.findByUserName(name);
    }

    @PostMapping("api/v1/updateById")
    public Stud updateById(@PathVariable Stud stud){
        return userService.updateById(stud);
    }

    @DeleteMapping("api/v1/deletestudentById/{id}")
    public String deleteStudentById(@PathVariable int id){
        return userService.deleteById(id);
    }

    @PutMapping("api/v1/getstudentById/updateStudent")
    public Stud updateStudent(@RequestBody Stud stud){
        return userService.updateById(stud);
    }



}
