package com.riwi.perfomancetest.api.dto.request;


import com.riwi.perfomancetest.utils.enums.MultimediaType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MultimediaRequest {

    @NotBlank(message = "The type is required")
    private MultimediaType multimediaType;
    @NotBlank(message = "The url is required")
    private String url;
    @NotBlank(message = "The status is required")
    private Boolean active;
    @NotBlank(message = "The lesson id is required")
    private Long lesson_id;
}
