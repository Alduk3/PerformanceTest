package com.riwi.perfomancetest.infrastructure.services;

import com.riwi.perfomancetest.api.dto.request.ClassRequest;
import com.riwi.perfomancetest.api.dto.response.ClassResponse;
import com.riwi.perfomancetest.api.dto.response.StudentBasicResponse;
import com.riwi.perfomancetest.domain.entities.ClassEntity;
import com.riwi.perfomancetest.domain.entities.StudentEntity;
import com.riwi.perfomancetest.domain.respositories.ClassRepository;
import com.riwi.perfomancetest.infrastructure.abstract_services.IClassService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ClassService implements IClassService {

    @Autowired
    private ClassRepository classRepository;

    @Override
    public ClassResponse create(ClassRequest request) {
        ClassEntity classEntity = this.requestToEntity(request);

        return this.entityToResponse(this.classRepository.save(classEntity));
    }

    @Override
    public ClassResponse get(Long id) {

        return this.entityToResponse(this.find(id));
    }

    @Override
    public ClassResponse update(ClassRequest request, Long id) {

        ClassEntity classEntity = this.find(id);
        ClassEntity classUpdate = this.requestToEntity(request);

        classUpdate.setId(classEntity.getId());

        return this.entityToResponse(this.classRepository.save(classUpdate));
    }

    @Override
    public void delete(Long id) {
        this.classRepository.delete(this.find(id));
    }

    @Override
    public Page<ClassResponse> getAll(int page, int size) {
        if (page < 0) page = 0;
        PageRequest pagination = PageRequest.of(page, size);

        return this.classRepository.findAll(pagination).map(this::entityToResponse);
    }

    private ClassEntity find(Long id) {
        return this.classRepository.findById(id).orElseThrow(null); // Add Error handler
    }

    private ClassResponse entityToResponse(ClassEntity entity) {

        List<StudentBasicResponse> students = entity.getStudents().stream().map(this::entityToStudentBasicResponse).toList();

        return ClassResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .creationDate(entity.getCreationDate())
                .active(entity.isActive())
                .students(students)
                .build();
    }

    private StudentBasicResponse entityToStudentBasicResponse(StudentEntity entity) {
        return StudentBasicResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .creationDate(entity.getCreationDate())
                .active(entity.isActive())
                .build();
    }

    private ClassEntity requestToEntity(ClassRequest request) {
        return ClassEntity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .active(request.isActive())
                .build();
    }
}
