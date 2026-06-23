package com.login.infrastructure.adapter.output.persistence.repository;

import com.login.infrastructure.adapter.output.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}