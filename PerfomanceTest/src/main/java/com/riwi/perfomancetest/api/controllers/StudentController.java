package com.riwi.perfomancetest.api.controllers;

import com.riwi.perfomancetest.api.dto.request.StudentRequest;
import com.riwi.perfomancetest.api.dto.response.StudentBasicResponse;
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
    public ResponseEntity<Page<StudentResponse>> getAllBasic(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(this.studentService.getAll(page -1, size));
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

//    @PatchMapping(path = "/{id}/{status}")
//    public ResponseEntity<StudentResponse> updateStatus(@PathVariable Long id, @PathVariable String status) {
//        if (status.equals("deactivate") || status.equals("activate")){
//            return ResponseEntity.ok(this.studentService.updateStatus(id));
//        }
//        return ResponseEntity.badRequest().build();
//    }

    @PatchMapping(path = "/{id}/disable")
    public ResponseEntity<StudentResponse> updateStatus(@PathVariable Long id) {
        return ResponseEntity.ok(this.studentService.updateStatus(id));

    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
