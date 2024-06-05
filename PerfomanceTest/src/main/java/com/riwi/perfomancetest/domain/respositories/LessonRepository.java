package com.riwi.perfomancetest.domain.respositories;

import com.riwi.perfomancetest.domain.entities.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<LessonEntity, Long> {
}
