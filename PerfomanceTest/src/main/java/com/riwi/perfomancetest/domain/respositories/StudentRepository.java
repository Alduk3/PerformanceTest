package com.riwi.perfomancetest.domain.respositories;

import com.riwi.perfomancetest.domain.entities.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    Page<StudentEntity> findByNameContainingAndActiveTrue(String name, PageRequest pageable);
    Page<StudentEntity> findByActiveTrue(PageRequest pageable);

}
