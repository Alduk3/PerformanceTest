package com.riwi.perfomancetest.api.dto.response;

import com.riwi.perfomancetest.utils.enums.MultimediaType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MultimediaResponse {
    private Long id;
    private MultimediaType multimediaType;
    private String url;
    private LocalDateTime created;
    private Boolean active;
}
