package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Department;
import com.cg.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    // Insert Department
    @PostMapping("/department")
    public ResponseEntity<?> addDepartment(@RequestBody @Valid Department dept) {

        Department saved = service.addDepartment(dept);

        return new ResponseEntity<>(
                "Department added successfully with ID: " + saved.getId(),
                HttpStatus.CREATED
        );
    }
}
