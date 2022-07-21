package com.example.apidemo.Service;

import com.example.apidemo.entitiesPackage.Stud;
import com.example.apidemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    StudentRepository studentRepository;

    public Stud saveStudent(Stud stud) {
        return studentRepository.save(stud);
    }

    public List<Stud> saveStudents(List<Stud> stud){
        return studentRepository.saveAll(stud);
    }

    public List<Stud> getStudents(){
        return studentRepository.findAll();
    }

    public Stud getStudentsById(int id){
        return studentRepository.findById(id).orElse(null);

    }

    public String deleteById(int id){
        studentRepository.deleteById(id);
        return "Student removed: " +id;
    }

    public Stud updateById(Stud stud){
        Stud studs = studentRepository.findById(stud.getId()).orElse(null);

        studs.setFullName(stud.getFullName());
        studs.setUserName(stud.getUserName());
        studs.setPassword(stud.getPassword());

        return studentRepository.save(studs);
    }


    public Stud findByUserName(String student1){
        return studentRepository.findByUserName(student1);
    }
}
