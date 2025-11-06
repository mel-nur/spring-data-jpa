package com.melikenur.controller.impl;

import com.melikenur.controller.IEmployeeController;
import com.melikenur.dto.DtoEmployee;
import com.melikenur.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("rest/api/employee")
public class EmployeeControllerImpl implements IEmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping(path = "/list")
    @Override
    public List<DtoEmployee> findAllEmployees() {
        // GET /rest/api/employee/list
        // Tüm çalışanları getiren endpoint. Service katmanından alınan
        // liste doğrudan döndürülür.
        return employeeService.findAllEmployees();
    }
}
