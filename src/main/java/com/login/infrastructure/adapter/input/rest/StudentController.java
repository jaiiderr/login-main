package com.login.infrastructure.adapter.input.rest;

import com.login.infrastructure.adapter.output.persistence.entity.StudentEntity;
import com.login.infrastructure.adapter.output.persistence.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;

    // GUARDA EN BASE DE DATOS REAL
    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody StudentRequest request) {

        StudentEntity student = StudentEntity.builder()
                .name(request.getName())
                .age(request.getAge())
                .build();

        studentRepository.save(student);

        return ResponseEntity.ok("Estudiante guardado en MySQL");
    }

    //CONSULTA DESDE BASE DE DATOS
    @GetMapping
    public ResponseEntity<List<StudentEntity>> getStudents() {

        return ResponseEntity.ok(studentRepository.findAll());
    }
}