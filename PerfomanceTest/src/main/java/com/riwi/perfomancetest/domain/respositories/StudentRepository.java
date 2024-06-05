package com.riwi.perfomancetest.domain.respositories;

import com.riwi.perfomancetest.domain.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
