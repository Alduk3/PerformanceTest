package com.riwi.perfomancetest.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "class")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime creationDate = LocalDateTime.now();
    @Column(nullable = false)
    private boolean active;

    @OneToMany(mappedBy = "classEntity", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<StudentEntity> students;

    @OneToMany(mappedBy = "classEntity", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<LessonEntity> lessons;
}
