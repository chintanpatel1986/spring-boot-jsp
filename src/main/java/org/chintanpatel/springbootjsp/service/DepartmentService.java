package org.chintanpatel.springbootjsp.service;

import org.chintanpatel.springbootjsp.model.Department;

import java.util.List;

public interface DepartmentService {

    void addDepartment(Department department);

    List<Department>getAllDepartmentList();

    Department getDepartmentById(Long departmentId);

    void deleteDepartmentById(Long departmentId);
}
