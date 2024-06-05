package com.riwi.perfomancetest.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassRequest {
    @NotBlank(message = "The name is required")
    private String name;
    @NotBlank(message = "The description is required")
    private String description;
    private boolean active;
}
