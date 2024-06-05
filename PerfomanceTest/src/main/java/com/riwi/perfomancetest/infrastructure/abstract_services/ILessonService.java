package com.riwi.perfomancetest.infrastructure.abstract_services;

import com.riwi.perfomancetest.api.dto.request.LessonRequest;
import com.riwi.perfomancetest.api.dto.response.LessonResponse;

public interface ILessonService extends CRUDService<LessonRequest, LessonResponse, Long>{
}
