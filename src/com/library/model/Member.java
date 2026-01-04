package com.library.model;

/**
 * Bu sınıf, kütüphaneye kayıtlı bir üyeyi temsil eder.
 * Üyeler kitap ödünç alabilir ve iade edebilir.
 */
public class Member {

    protected int id;
    protected String name;

    /**
     * Member sınıfı için kurucu metot.
     *
     * @param id Üye kimliği
     * @param name Üye adı
     */
    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Üye kimliğini döndürür.
     */
    public int getId() {
        return id;
    }

    /**
     * Üye adını döndürür.
     */
    public String getName() {
        return name;
    }
}
