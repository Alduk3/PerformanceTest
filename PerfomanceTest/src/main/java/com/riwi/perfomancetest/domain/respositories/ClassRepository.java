package com.riwi.perfomancetest.domain.respositories;

import com.riwi.perfomancetest.domain.entities.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
}
