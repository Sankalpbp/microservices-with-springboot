package io.sankalp.departmentservice.service;

import io.sankalp.departmentservice.entity.Department;
import io.sankalp.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(final Department department) {
        log.info("Inside saveDepartment method of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(final Long id) {
        log.info("Inside findDepartmentById method of DepartmentService");
        return departmentRepository.findById(id)
                                   .orElse(null);
    }
}
