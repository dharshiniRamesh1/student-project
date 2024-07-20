package com.studentproject.controller;

import com.studentproject.entity.Student;
import com.studentproject.exception.StudentNotFoundException;
import com.studentproject.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin("http://localhost:3000")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/studentsave")
    Student newUser(@RequestBody Student student) {
    	System.out.println("From student controller"+student.getStudentName());
    	return studentRepository.save(student);
    }

    @GetMapping("/studentget")
    List<Student> getAllUsers() {
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    Student getUserById(@PathVariable Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @PutMapping("/studentupdate/{id}")
    Student updateUser(@RequestBody Student newStudent, @PathVariable Long id) {
        return studentRepository.findById(id).map(student -> {
        	student.setStudentName(newStudent.getStudentName());
        	student.setStudentAddress(newStudent.getStudentAddress());
        	student.setEmail(newStudent.getEmail());
            return studentRepository.save((student));
        }).orElseThrow(() -> new StudentNotFoundException(id));
    }
    @DeleteMapping("/studentdelete/{id}")
    String deleteUser(@PathVariable Long id){
        if(!studentRepository.existsById(id)){
            throw new  StudentNotFoundException(id);

        }
        studentRepository.deleteById(id);
        return "student with id " +id+ "has been deleted successfylly";

    }

}


