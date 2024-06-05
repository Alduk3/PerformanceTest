package com.riwi.perfomancetest.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonBasicResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createAt;
    private boolean active;
}
