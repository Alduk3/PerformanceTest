package com.riwi.perfomancetest.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    @NotBlank(message = "The name is required")
    private String name;
    @NotBlank(message = "The email is required")
    private String email;
    @NotNull(message = "The status is required")
    private boolean active;
    @NotNull(message = "The class id is required")
    private Long class_id;
}
