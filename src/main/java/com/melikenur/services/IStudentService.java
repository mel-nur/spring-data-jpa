package com.melikenur.services;

import com.melikenur.dto.DtoStudent;
import com.melikenur.dto.DtoStudentIU;

import java.util.List;

public interface IStudentService {
    /**
     * Yeni öğrenci oluşturur.
     * @param student giriş DTO (validation uygulanmış)
     * @return oluşturulan öğrenci DTO
     */
    public DtoStudent saveStudent(DtoStudentIU student);

    /**
     * Tüm öğrencileri listeler.
     * @return öğrenci DTO listesi
     */
    public List<DtoStudent> getAllStudents();

    /**
     * Id ile öğrenci getirir.
     * @param id öğrenci id
     * @return DtoStudent veya null
     */
    public DtoStudent getStudentById(Integer id);

    /**
     * Id ile öğrenci siler.
     * @param id öğrenci id
     */
    public void deleteStudent(Integer id);

    /**
     * Var olan öğrenciyi günceller.
     * @param id güncellenecek öğrenci id
     * @param dtoStudentIU güncelleme için gelen veri
     * @return güncellenmiş öğrenci DTO veya null
     */
    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU);
}
