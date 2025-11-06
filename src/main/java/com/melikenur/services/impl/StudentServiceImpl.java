package com.melikenur.services.impl;

import com.melikenur.dto.DtoCourse;
import com.melikenur.dto.DtoStudent;
import com.melikenur.dto.DtoStudentIU;
import com.melikenur.entites.Course;
import com.melikenur.repository.StudentRepository;
import com.melikenur.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.melikenur.entites.Student;
import com.melikenur.dto.DtoStudentIU;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
        // Yeni öğrenci yaratma işlemi: input DTO -> entity -> persist -> DTO
        DtoStudent response = new DtoStudent();
        Student student = new Student();
        BeanUtils.copyProperties(dtoStudentIU, student);

        Student dbStudent = studentRepository.save(student);
        BeanUtils.copyProperties(dbStudent, response);
        return response;
    }

    @Override
    public List<DtoStudent> getAllStudents() {
        // Tüm öğrencileri getirir ve DTO'ya dönüştürür.
        List<DtoStudent> dtoList = new ArrayList<>();

        List<Student> studentList = studentRepository.findAllStudents();
        for (Student student : studentList) {
            DtoStudent dto = new DtoStudent();
            BeanUtils.copyProperties(student, dto);

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public DtoStudent getStudentById(Integer id) {
        // Id'ye göre öğrenci getirir; ilişki olarak varsa kursları DTO'ya dönüştürür.
        DtoStudent dtoStudent = new DtoStudent();
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        Student dbStudent = optional.get();
        BeanUtils.copyProperties(dbStudent, dtoStudent);

        if (dbStudent.getCourses() != null && !dbStudent.getCourses().isEmpty()) {
            for (Course course : dbStudent.getCourses()) {
                DtoCourse dtoCourse = new DtoCourse();
                BeanUtils.copyProperties(course, dtoCourse);

                dtoStudent.getCourses().add(dtoCourse);
            }
        }

        return dtoStudent;
    }

    @Override
    public void deleteStudent(Integer id) {
        // Id ile öğrenciyi siler; önce var mı kontrol edilir.
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            studentRepository.delete(optional.get());
        }

    }

    @Override
    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {
        // Mevcut öğrenciyi günceller: var mı kontrolü -> alanları set et -> persist
        DtoStudent dto = new DtoStudent();

        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            Student dbStudent = optional.get();

            dbStudent.setFirstName(dtoStudentIU.getFirstName());
            dbStudent.setLastName(dtoStudentIU.getLastName());
            dbStudent.setBirthOfDate(dtoStudentIU.getBirthOfDate());

            Student updatedStudent = studentRepository.save(dbStudent);

            BeanUtils.copyProperties(updatedStudent, dto);
            return dto;

        }
        return null;
    }
}
