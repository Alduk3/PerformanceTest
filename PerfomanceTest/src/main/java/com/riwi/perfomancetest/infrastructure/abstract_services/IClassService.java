package com.riwi.perfomancetest.infrastructure.abstract_services;

import com.riwi.perfomancetest.api.dto.request.ClassRequest;
import com.riwi.perfomancetest.api.dto.response.ClassBasicResponse;
import com.riwi.perfomancetest.api.dto.response.ClassResponse;
import org.springframework.data.domain.Page;

public interface IClassService extends CRUDService<ClassRequest, ClassResponse, Long> {
    public Page<ClassBasicResponse> getAllBasic(int page, int size, String name);
    public Page<ClassBasicResponse> getAllBasic(int page, int size);
}
