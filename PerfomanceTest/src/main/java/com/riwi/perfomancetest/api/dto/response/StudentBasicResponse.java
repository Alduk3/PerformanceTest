package com.riwi.perfomancetest.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentBasicResponse {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime creationDate;
    private boolean active;
}
