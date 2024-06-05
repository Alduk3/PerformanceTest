package com.riwi.perfomancetest.domain.entities;

import com.riwi.perfomancetest.utils.enums.MultimediaType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "multimedia")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MultimediaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MultimediaType multimediaType;
    @Column(columnDefinition = "TEXT",nullable = false)
    private String url;
    @Column(nullable = false)
    private LocalDateTime created = LocalDateTime.now();
    @Column(nullable = false)
    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    private LessonEntity lessonEntity;

}
