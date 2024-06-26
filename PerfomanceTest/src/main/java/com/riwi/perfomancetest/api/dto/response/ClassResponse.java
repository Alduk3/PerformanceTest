package com.riwi.perfomancetest.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassResponse {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private boolean active;
    private List<StudentBasicResponse> students;
    private List<LessonBasicResponse> lessons;
}
