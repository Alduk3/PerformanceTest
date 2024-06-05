package com.riwi.perfomancetest.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "Your email is not valid")
    private String email;
    @NotNull(message = "The status is required")
    private boolean active;
    @NotNull(message = "The class id is required")
    private Long class_id;
}
