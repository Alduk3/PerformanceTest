package com.riwi.perfomancetest.api.dto.request;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonRequest {

    @NotBlank(message = "The name is required")
    private String title;
    @NotBlank(message = "The name is required")
    private String description;
    @NotNull(message = "The name is required")
    private boolean active;
    @NotNull(message = "The name is required")
    private Long classId;
}
