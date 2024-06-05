package com.riwi.perfomancetest.infrastructure.abstract_services;

import com.riwi.perfomancetest.api.dto.request.ClassRequest;
import com.riwi.perfomancetest.api.dto.response.ClassResponse;

public interface IClassService extends CRUDService<ClassRequest, ClassResponse, Long> {
}
