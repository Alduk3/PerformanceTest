package com.riwi.perfomancetest.domain.respositories;

import com.riwi.perfomancetest.domain.entities.MultimediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultimediaRepository extends JpaRepository<MultimediaEntity, Long> {
}
