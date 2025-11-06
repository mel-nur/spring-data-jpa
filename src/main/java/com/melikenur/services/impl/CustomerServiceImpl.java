package com.melikenur.services.impl;

import com.melikenur.dto.DtoAddress;
import com.melikenur.dto.DtoCustomer;
import com.melikenur.entites.Address;
import com.melikenur.entites.Customer;
import com.melikenur.repository.CustomerRepository;
import com.melikenur.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public DtoCustomer findCustomerById(Long id) {
        // Repository'den Customer alır, DTO'ya çevirir ve ilişkili Address'i de
        // DTO olarak ekler. BeanUtils ile basit alan kopyalama yapılır.
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();

        Optional<Customer> optional = customerRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        Customer customer = optional.get();
        Address address = customer.getAddress();

        BeanUtils.copyProperties(customer, dtoCustomer);

        // Address null olabilir, o yüzden kontrol ediyoruz
        if (address != null) {
            BeanUtils.copyProperties(address, dtoAddress);
            dtoCustomer.setAddress(dtoAddress);
        }

        return dtoCustomer;
    }
}
