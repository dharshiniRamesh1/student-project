package com.studentproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "StudentRegistraions")
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String studentName;
    private String studentAddress;
    private String email;
    }




