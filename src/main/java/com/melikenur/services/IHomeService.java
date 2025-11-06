package com.melikenur.services;

import com.melikenur.dto.DtoHome;

public interface IHomeService {
    /**
     * Verilen id'ye göre veritabanından ev bilgisi getirir ve DTO olarak döner.
     * Service katmanı, repository ile veri tabanı iletişimini yönetir,
     * null/empty durumlarını controller katmanına uygun şekilde iletmeli veya
     * özel exception fırlatmalıdır.
     *
     * @param id ev id
     * @return DtoHome veya null
     */
    public DtoHome findHomeById(Long id);
}
