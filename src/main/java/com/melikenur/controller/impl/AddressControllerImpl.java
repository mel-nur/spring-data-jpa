package com.melikenur.controller.impl;

import com.melikenur.controller.IAddressController;
import com.melikenur.dto.DtoAddress;
import com.melikenur.services.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/address")
public class AddressControllerImpl implements IAddressController {

    @Autowired
    private IAddressService addressService;

    @GetMapping(path = "/list/{id}")
    @Override
    public DtoAddress findAddressById(@PathVariable(name="id") Long id) {
        // HTTP GET -> /rest/api/address/list/{id}
        // Service katmanından DtoAddress alır ve direkt döner.
        // Daha gelişmiş bir uygulamada bulunamayan kayıt için 404 dönmek
        // veya uygun bir hata nesnesi fırlatmak tercih edilir.
        return addressService.findAddressById(id);
    }
}
