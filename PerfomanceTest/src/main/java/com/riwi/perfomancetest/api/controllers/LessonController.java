package com.riwi.perfomancetest.api.controllers;

import com.riwi.perfomancetest.api.dto.request.LessonRequest;
import com.riwi.perfomancetest.api.dto.request.StudentRequest;
import com.riwi.perfomancetest.api.dto.response.LessonResponse;
import com.riwi.perfomancetest.api.dto.response.StudentResponse;
import com.riwi.perfomancetest.infrastructure.abstract_services.ILessonService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/lesson")
@AllArgsConstructor
public class LessonController {
    private final ILessonService lessonService;

    @GetMapping
    public ResponseEntity<Page<LessonResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(this.lessonService.getAll(page-1, size));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<LessonResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.lessonService.get(id));
    }

    @PostMapping
    public ResponseEntity<LessonResponse> insert(@Validated @RequestBody LessonRequest lessonRequest) {
        return ResponseEntity.ok(this.lessonService.create(lessonRequest));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<LessonResponse> update(
            @Validated @RequestBody LessonRequest lessonRequest,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.lessonService.update(lessonRequest, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.lessonService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
