package io.sankalp.departmentservice.controller;

import io.sankalp.departmentservice.entity.Department;
import io.sankalp.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody final Department department) {
        log.info("Inside saveDepartment method of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById (@PathVariable Long id) {
        log.info("Inside findDepartmentById method of DepartmentController");
        return departmentService.findDepartmentById(id);
    }
}
