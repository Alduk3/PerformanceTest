package com.riwi.perfomancetest.api.controllers;

import com.riwi.perfomancetest.api.dto.request.ClassRequest;
import com.riwi.perfomancetest.api.dto.response.ClassBasicResponse;
import com.riwi.perfomancetest.api.dto.response.ClassResponse;
import com.riwi.perfomancetest.infrastructure.abstract_services.IClassService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/class")
@AllArgsConstructor
public class ClassController {

    private final IClassService classService;

//    @GetMapping
//    public ResponseEntity<Page<ClassResponse>> getAll(
//            @RequestParam(defaultValue = "1") int page,
//            @RequestParam(defaultValue = "10") int size
//    ) {
//        return ResponseEntity.ok(this.classService.getAll(page-1, size));
//    }

    @GetMapping
    public ResponseEntity<Page<ClassBasicResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String name
    ) {
        if (name != null) {
            return ResponseEntity.ok(this.classService.getAllBasic(page-1, size, name));
        } else {
            return ResponseEntity.ok(this.classService.getAllBasic(page-1, size));
        }

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClassResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.classService.get(id));
    }

    @PostMapping
    public ResponseEntity<ClassResponse> insert(@Validated @RequestBody ClassRequest classRequest) {
        return ResponseEntity.ok(this.classService.create(classRequest));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ClassResponse> update(
            @Validated @RequestBody ClassRequest classRequest,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.classService.update(classRequest, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.classService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
