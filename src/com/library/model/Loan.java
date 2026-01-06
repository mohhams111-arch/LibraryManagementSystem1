// Model (veri) sınıflarının bulunduğu paket
package com.library.model;

// Tarih işlemleri için LocalDate sınıfı
import java.time.LocalDate;

/**
 * Loan sınıfı, bir kitabın bir üye tarafından
 * belirli bir tarihte ödünç alınmasını temsil eder.
 * Bu sınıf ödünç alma ve iade tarihlerini takip eder.
 */
public class Loan {

    // Ödünç alınan kitabı temsil eder
    private Book book;

    // Kitabı ödünç alan üyeyi temsil eder
    private Member member;

    // Kitabın ödünç alındığı tarihi tutar
    private LocalDate borrowDate;

    // Kitabın iade edildiği tarihi tutar
    private LocalDate returnDate;

    /**
     * Loan sınıfı için kurucu metot.
     * Ödünç alma tarihi parametre olarak verilir.
     *
     * @param book ödünç alınan kitap
     * @param member kitabı ödünç alan üye
     * @param borrowDate ödünç alma tarihi
     */
    public Loan(Book book, Member member, LocalDate borrowDate) {

        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.returnDate = null;
    }

    /**
     * Loan sınıfı için alternatif kurucu metot.
     * Ödünç alma tarihi otomatik olarak bugünün tarihi olarak atanır.
     *
     * @param book ödünç alınan kitap
     * @param member kitabı ödünç alan üye
     */
    public Loan(Book book, Member member) {

        this.book = book;
        this.member = member;
        this.borrowDate = LocalDate.now();
        this.returnDate = null;
    }

    /**
     * Kitabın iade edilmesini sağlar.
     * İade tarihi bugünün tarihi olarak ayarlanır.
     */
    public void returnBook() {

        this.returnDate = LocalDate.now();
    }

    /**
     * Ödünç alınan kitabı döndürür.
     *
     * @return ödünç alınan kitap
     */
    public Book getBook() {

        return book;
    }

    /**
     * Kitabı ödünç alan üyeyi döndürür.
     *
     * @return üye bilgisi
     */
    public Member getMember() {

        return member;
    }

    /**
     * Ödünç alma tarihini döndürür.
     *
     * @return ödünç alma tarihi
     */
    public LocalDate getBorrowDate() {

        return borrowDate;
    }

    /**
     * Kitabın iade tarihini döndürür.
     *
     * @return iade tarihi
     */
    public LocalDate getReturnDate() {

        return returnDate;
    }

    /**
     * İade tarihini manuel olarak ayarlamak için kullanılır.
     *
     * @param returnDate iade tarihi
     */
    public void setReturnDate(LocalDate returnDate) {

        this.returnDate = returnDate;
    }
}
