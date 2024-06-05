package com.riwi.perfomancetest.api.controllers;

import com.riwi.perfomancetest.api.dto.request.ClassRequest;
import com.riwi.perfomancetest.api.dto.request.StudentRequest;
import com.riwi.perfomancetest.api.dto.response.ClassResponse;
import com.riwi.perfomancetest.api.dto.response.StudentResponse;
import com.riwi.perfomancetest.infrastructure.abstract_services.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/student")
@AllArgsConstructor
public class StudentController {
    private final IStudentService studentService;

    @GetMapping
    public ResponseEntity<Page<StudentResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(this.studentService.getAll(page-1, size));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StudentResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.studentService.get(id));
    }

    @PostMapping
    public ResponseEntity<StudentResponse> insert(@Validated @RequestBody StudentRequest studentRequest) {
        return ResponseEntity.ok(this.studentService.create(studentRequest));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<StudentResponse> update(
            @Validated @RequestBody StudentRequest studentRequest,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.studentService.update(studentRequest, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
