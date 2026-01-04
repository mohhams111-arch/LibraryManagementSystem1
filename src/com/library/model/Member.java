// Model (veri) sınıflarının bulunduğu paket
package com.library.model;

/**
 * Member sınıfı
 * Kütüphaneye kayıtlı bir üyeyi temsil eder.
 * Üyeler kitap ödünç alabilir ve iade edebilir.
 */
public class Member {

    // Üyenin benzersiz kimlik numarasını tutan değişken
    protected int id;

    // Üyenin adını tutan değişken
    protected String name;

    /**
     * Member sınıfı için kurucu metot
     *
     * @param id Üye kimliği
     * @param name Üye adı
     */
    public Member(int id, String name) {

        // Üye kimliği atanır
        this.id = id;

        // Üye adı atanır
        this.name = name;
    }

    /**
     * Üyenin kimlik numarasını döndürür.
     *
     * @return id
     */
    public int getId() {

        // Üye kimliği geri döndürülür
        return id;
    }

    /**
     * Üyenin adını döndürür.
     *
     * @return name
     */
    public String getName() {

        // Üye adı geri döndürülür
        return name;
    }
}
