package com.melikenur.controller.impl;

import com.melikenur.controller.IHomeController;
import com.melikenur.dto.DtoHome;
import com.melikenur.services.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/home")
public class HomeControllerImpl implements IHomeController {

    @Autowired
    private IHomeService homeService;

    @GetMapping(path = "/{id}")
    @Override
    public DtoHome findHomeById(@PathVariable(name = "id") Long id) {
        // HTTP GET /rest/api/home/{id} isteğini karşılayan controller metodu
        // İş mantığı için service katmanını çağırır. Service null dönebilirse
        // burada uygun HTTP dönüşü (404 vb.) dönmek tercih edilebilir; bu örnekte
        // doğrudan DTO döndürülüyor.
        return homeService.findHomeById(id);
    }
}
