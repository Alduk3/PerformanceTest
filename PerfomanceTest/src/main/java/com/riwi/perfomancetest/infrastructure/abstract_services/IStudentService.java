package com.riwi.perfomancetest.infrastructure.abstract_services;

import com.riwi.perfomancetest.api.dto.request.StudentRequest;
import com.riwi.perfomancetest.api.dto.response.StudentBasicResponse;
import com.riwi.perfomancetest.api.dto.response.StudentResponse;
import org.springframework.data.domain.Page;

public interface IStudentService extends CRUDService<StudentRequest, StudentResponse, Long>{
    public StudentResponse updateStatus(Long id);
    public Page<StudentBasicResponse> getAllBasic(int page, int size);
    public Page<StudentBasicResponse> getAllBasic(int page, int size, String name);
}
