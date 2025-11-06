package com.melikenur.controller.impl;

import com.melikenur.controller.ICustomerController;
import com.melikenur.dto.DtoCustomer;
import com.melikenur.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/customer")
public class CustomerControllerImpl implements ICustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping(path = "/list/{id}")
    @Override
    public DtoCustomer findCustomerById(@PathVariable(name = "id") Long id) {
        // GET /rest/api/customer/list/{id}
        // Servis çağrısı ile DTO alınır ve döndürülür. Hata yönetimi
        // global exception handler veya ResponseEntity ile yapılabilir.
        return customerService.findCustomerById(id);
    }
}
