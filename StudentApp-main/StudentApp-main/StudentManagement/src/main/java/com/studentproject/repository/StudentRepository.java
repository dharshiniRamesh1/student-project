package com.studentproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.studentproject.entity.Student;



public interface StudentRepository extends JpaRepository<Student,Long> {
}

