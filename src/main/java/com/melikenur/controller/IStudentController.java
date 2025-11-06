package com.melikenur.controller;


import com.melikenur.dto.DtoStudent;
import com.melikenur.dto.DtoStudentIU;

import java.util.List;

public interface IStudentController {
    /**
     * Yeni bir öğrenci kaydı oluşturur.
     * @param dtoStudentIU giriş (input) DTO'su — validation uygulanır
     * @return oluşturulan öğrenci DTO'su
     */
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);

    /**
     * Tüm öğrencileri liste olarak döner.
     * @return öğrenci DTO listesi
     */
    public List<DtoStudent> getAllStudents();

    /**
     * Verilen id'ye sahip öğrenciyi döner.
     * @param id öğrenci id
     * @return DtoStudent veya null
     */
    public DtoStudent getStudentById(Integer id);

    /**
     * Verilen id'ye sahip öğrenciyi siler.
     * @param id öğrenci id
     */
    public void deleteStudent(Integer id);

    /**
     * Var olan öğrenciyi günceller.
     * @param id güncellenecek öğrencinin id'si
     * @param dtoStudentIU güncelleme için gelen veri
     * @return güncellenmiş öğrenci DTO'su
     */
    public DtoStudent updateStudent(Integer id , DtoStudentIU dtoStudentIU);
}
