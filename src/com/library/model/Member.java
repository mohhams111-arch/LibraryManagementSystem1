package com.library.model;

/**
 * Bu sınıf, kütüphane sistemine kayıtlı bir üyeyi temsil eder.
 * Üyeler, sistem üzerinden kitap ödünç alabilir ve iade edebilir.
 */
public class Member {

    /** Üyenin benzersiz kimlik numarası */
    protected int id;

    /** Üyenin adı */
    protected String name;

    /**
     * Member sınıfı için kurucu metot.
     *
     * @param id   Üyenin kimlik numarası
     * @param name Üyenin adı
     */
    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Üyenin kimlik numarasını döndürür.
     *
     * @return üye kimlik numarası
     */
    public int getId() {
        return id;
    }

    /**
     * Üyenin adını döndürür.
     *
     * @return üye adı
     */
    public String getName() {
        return name;
    }
}
