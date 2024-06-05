package com.riwi.perfomancetest.domain.respositories;

import com.riwi.perfomancetest.domain.entities.ClassEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
    Page<ClassEntity> findByNameContainingAndActiveTrue(String name, PageRequest pageable);
    Page<ClassEntity> findByActiveTrue(PageRequest pageable);
}
