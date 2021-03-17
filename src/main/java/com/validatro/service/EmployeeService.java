package com.validatro.service;

import com.validatro.beans.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class EmployeeService {

    public String save(Employee employee) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        System.out.println("save employee");
        AtomicReference<Employee> employee1 = new AtomicReference<>();
        if (employeeList!=null) {
            employeeList.stream().forEach(x -> {
                if (x.getName().equals(employee.getName())) {
                    employee1.set(employee);
                }
            });
            return employee1.get().getName();
        }
        return employee.getName();
    }
}
