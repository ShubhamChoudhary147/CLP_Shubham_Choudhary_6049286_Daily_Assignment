package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Department;
import com.cg.repository.IDepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private IDepartmentRepository repo;

    public Department addDepartment(Department dept) {
        return repo.save(dept);
    }
}
