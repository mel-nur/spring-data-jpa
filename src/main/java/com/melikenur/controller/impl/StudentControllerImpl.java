package com.melikenur.controller.impl;

import com.melikenur.controller.IStudentController;
import com.melikenur.dto.DtoStudent;
import com.melikenur.dto.DtoStudentIU;
import com.melikenur.services.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping(path = "/save")
    @Override
    public DtoStudent saveStudent(@RequestBody @Valid DtoStudentIU dtoStudentIU) {
        // POST /rest/api/student/save
        // Yeni öğrenci oluşturma isteğini karşılar. @Valid ile gelen DTO
        // üzerinde bean validation çalışır. Service çağrısı sonucu oluşan
        // DtoStudent döndürülür.
        return studentService.saveStudent(dtoStudentIU);
    }

    @GetMapping(path = "/list")
    @Override
    public List<DtoStudent> getAllStudents() {
        // GET /rest/api/student/list
        // Tüm öğrencileri döner.
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public DtoStudent getStudentById(@PathVariable(name = "id") Integer id) {
        // GET /rest/api/student/list/{id}
        // Tek öğrenci getirir.
        return studentService.getStudentById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteStudent(@PathVariable(name = "id") Integer id) {
        // DELETE /rest/api/student/delete/{id}
        // Servis katmanını çağırarak öğrenciyi siler.
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public DtoStudent updateStudent(@PathVariable(name = "id") Integer id, DtoStudentIU dtoStudentIU) {
        // PUT /rest/api/student/update/{id}
        // Öğrenci güncelleme isteğini işler.
        return studentService.updateStudent(id, dtoStudentIU);
    }
}


