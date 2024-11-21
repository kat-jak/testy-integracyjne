package com.example.IntegrationTesting.controller;

import com.example.IntegrationTesting.domain.StudentEntity;
import com.example.IntegrationTesting.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api")

public class StudentRestController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/students")
    public ResponseEntity<StudentEntity>
    createStudent(@RequestBody StudentEntity student) {
        HttpStatus status = HttpStatus.CREATED;
        StudentEntity saved = studentService.save(student);
        return new ResponseEntity<>(saved, status);
    }
    @GetMapping("/students")
    public List<StudentEntity> getAllStudents() {
        return studentService.getAllStudents();
    }
}
