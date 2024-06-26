package com.riwi.perfomancetest.infrastructure.services;

import com.riwi.perfomancetest.api.dto.request.StudentRequest;
import com.riwi.perfomancetest.api.dto.response.ClassBasicResponse;
import com.riwi.perfomancetest.api.dto.response.StudentBasicResponse;
import com.riwi.perfomancetest.api.dto.response.StudentResponse;
import com.riwi.perfomancetest.domain.entities.ClassEntity;
import com.riwi.perfomancetest.domain.entities.StudentEntity;
import com.riwi.perfomancetest.domain.respositories.ClassRepository;
import com.riwi.perfomancetest.domain.respositories.StudentRepository;
import com.riwi.perfomancetest.infrastructure.abstract_services.IStudentService;
import com.riwi.perfomancetest.utils.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassRepository classRepository;

    @Override
    public StudentResponse create(StudentRequest request) {
        ClassEntity classEntity = this.classRepository.findById(request.getClass_id()).orElseThrow(() -> new BadRequestException("Class not found"));

        StudentEntity studentEntity = this.requestToEntity(request);
        studentEntity.setClassEntity(classEntity);

        return this.entityToResponse(this.studentRepository.save(studentEntity));
    }

    @Override
    public StudentResponse get(Long id) {
        return this.entityToResponse(this.find(id));
    }

    @Override
    public StudentResponse update(StudentRequest request, Long id) {
        StudentEntity studentEntity = this.find(id);
        ClassEntity classEntity = this.classRepository.findById(request.getClass_id()).orElseThrow(() -> new BadRequestException("Class not found"));

        studentEntity = this.requestToEntity(request);

        studentEntity.setClassEntity(classEntity);

        return this.entityToResponse(this.studentRepository.save(studentEntity));
    }

    @Override
    public StudentResponse updateStatus(Long id) {
        StudentEntity studentEntity = this.find(id);

        if (studentEntity.isActive()){
            studentEntity.setActive(false);
        }

        return this.entityToResponse(this.studentRepository.save(studentEntity));
    }




    @Override
    public void delete(Long id) {
        this.studentRepository.delete(this.find(id));

    }

    @Override
    public Page<StudentResponse> getAll(int page, int size) {
        if (page<0) page = 0;
        PageRequest pagination = PageRequest.of(page, size);

        return this.studentRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public Page<StudentBasicResponse> getAllBasic(int page, int size) {
        if (page<0) page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        return this.studentRepository.findByActiveTrue(pagination).map(this::entityToResponseBasic);
    }
    @Override
    public Page<StudentBasicResponse> getAllBasic(int page, int size, String name) {
        if (page<0) page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        return this.studentRepository.findByNameContainingAndActiveTrue(name, pagination).map(this::entityToResponseBasic);
    }


    private StudentEntity find(Long id) {
        return this.studentRepository.findById(id).orElseThrow(() -> new BadRequestException("Student not found"));
    }

    private StudentResponse entityToResponse(StudentEntity entity) {

        ClassBasicResponse classEntity = new ClassBasicResponse();
        BeanUtils.copyProperties(entity.getClassEntity(), classEntity);

        return StudentResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .creationDate(entity.getCreationDate())
                .active(entity.isActive())
                .classResponse(classEntity)
                .build();
    }

    private StudentBasicResponse entityToResponseBasic(StudentEntity entity) {
        return StudentBasicResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .creationDate(entity.getCreationDate())
                .active(entity.isActive())
                .build();
    }

    private StudentEntity requestToEntity(StudentRequest request) {
        return StudentEntity.builder()
                .name(request.getName())
                .email(request.getEmail())
                .active(request.isActive())
                .build();
    }
}
