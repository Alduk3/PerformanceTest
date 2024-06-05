package com.riwi.perfomancetest.infrastructure.abstract_services;

import com.riwi.perfomancetest.api.dto.request.StudentRequest;
import com.riwi.perfomancetest.api.dto.response.StudentResponse;

public interface IStudentService extends CRUDService<StudentRequest, StudentResponse, Long>{
}
