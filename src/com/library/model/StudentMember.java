// Model (veri) sınıflarının bulunduğu paket
package com.library.model;

/**
 * StudentMember sınıfı
 * Öğrenci üyeleri temsil eder.
 * Member sınıfından kalıtım (inheritance) alır.
 */
public class StudentMember extends Member {

    // Öğrenciye ait öğrenci numarasını tutan değişken
    private String studentNumber;

    /**
     * StudentMember sınıfı için kurucu metot
     *
     * @param id Üye kimliği
     * @param name Üye adı
     * @param studentNumber Öğrenci numarası
     */
    public StudentMember(int id, String name, String studentNumber) {

        // Üst sınıf olan Member sınıfının kurucu metodu çağrılır
        super(id, name);

        // Öğrenci numarası atanır
        this.studentNumber = studentNumber;
    }

    /**
     * Öğrenci numarasını döndürür.
     *
     * @return studentNumber
     */
    public String getStudentNumber() {

        // Öğrenci numarası geri döndürülür
        return studentNumber;
    }
}
