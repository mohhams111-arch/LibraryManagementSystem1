package com.library.model;

/**
 * Bu sınıf, öğrenci üyeleri temsil eder.
 * StudentMember sınıfı, Member sınıfından kalıtım alır
 * ve öğrencilere ait ek bilgileri içerir.
 */
public class StudentMember extends Member {

    /** Öğrenciye ait öğrenci numarası */
    private String studentNumber;

    /**
     * StudentMember sınıfı için kurucu metot.
     *
     * @param id            Üyenin kimlik numarası
     * @param name          Üyenin adı
     * @param studentNumber Öğrencinin öğrenci numarası
     */
    public StudentMember(int id, String name, String studentNumber) {
        super(id, name);
        this.studentNumber = studentNumber;
    }

    /**
     * Öğrencinin öğrenci numarasını döndürür.
     *
     * @return öğrenci numarası
     */
    public String getStudentNumber() {
        return studentNumber;
    }
}
