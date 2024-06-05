package com.riwi.perfomancetest.infrastructure.services;

import com.riwi.perfomancetest.api.dto.request.LessonRequest;
import com.riwi.perfomancetest.api.dto.response.ClassBasicResponse;
import com.riwi.perfomancetest.api.dto.response.LessonResponse;
import com.riwi.perfomancetest.domain.entities.ClassEntity;
import com.riwi.perfomancetest.domain.entities.LessonEntity;
import com.riwi.perfomancetest.domain.respositories.ClassRepository;
import com.riwi.perfomancetest.domain.respositories.LessonRepository;
import com.riwi.perfomancetest.infrastructure.abstract_services.ILessonService;
import com.riwi.perfomancetest.utils.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LessonService implements ILessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private ClassRepository classRepository;


    @Override
    public LessonResponse create(LessonRequest request) {
        ClassEntity classEntity = this.classRepository.findById(request.getClassId()).orElseThrow(() -> new BadRequestException("Class not found"));
        LessonEntity lessonEntity = this.requestToEntity(request);
        lessonEntity.setClassEntity(classEntity);
        return this.entityToResponse(this.lessonRepository.save(lessonEntity));
    }

    @Override
    public LessonResponse get(Long id) {
        return this.entityToResponse(this.find(id));
    }

    @Override
    public LessonResponse update(LessonRequest request, Long id) {
        LessonEntity lessonEntity = this.find(id);
        ClassEntity classEntity = this.classRepository.findById(request.getClassId()).orElseThrow(() -> new BadRequestException("Class not found"));

        lessonEntity = this.requestToEntity(request);

        lessonEntity.setClassEntity(classEntity);

        return this.entityToResponse(this.lessonRepository.save(lessonEntity));
    }

    @Override
    public void delete(Long id) {
        this.lessonRepository.delete(this.find(id));
    }

    @Override
    public Page<LessonResponse> getAll(int page, int size) {
        if (page<0) page = 0;

        PageRequest pagination = PageRequest.of(page, size);

        return this.lessonRepository.findAll(pagination).map(this::entityToResponse);
    }

    private LessonEntity find(Long id) {
        return this.lessonRepository.findById(id).orElseThrow(() -> new BadRequestException("Lesson not found"));
    }
    private LessonResponse entityToResponse(LessonEntity lessonEntity) {
        ClassBasicResponse classEntity = new ClassBasicResponse();
        BeanUtils.copyProperties(lessonEntity.getClassEntity(), classEntity);

        return LessonResponse.builder()
                .id(lessonEntity.getId())
                .title(lessonEntity.getTitle())
                .description(lessonEntity.getDescription())
                .createAt(lessonEntity.getCreateAt())
                .active(lessonEntity.isActive())
                .classResponse(classEntity)
                .build();
    }

    private LessonEntity requestToEntity(LessonRequest request) {
        return LessonEntity.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .active(request.isActive())
                .build();
    }
}
