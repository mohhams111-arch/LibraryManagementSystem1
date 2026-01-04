package com.library.model;

/**
 * Bu sınıf, öğrenci üyeleri temsil eder.
 * StudentMember sınıfı, Member sınıfından kalıtım alır.
 */
public class StudentMember extends Member {

    private String studentNumber;

    /**
     * StudentMember sınıfı için kurucu metot.
     *
     * @param id Üye kimliği
     * @param name Üye adı
     * @param studentNumber Öğrenci numarası
     */
    public StudentMember(int id, String name, String studentNumber) {
        super(id, name);
        this.studentNumber = studentNumber;
    }

    /**
     * Öğrenci numarasını döndürür.
     */
    public String getStudentNumber() {
        return studentNumber;
    }
}
