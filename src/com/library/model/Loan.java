// Model (veri) sınıflarının bulunduğu paket
package com.library.model;

// Tarih işlemleri için LocalDate sınıfı
import java.time.LocalDate;

/**
 * Loan sınıfı
 * Bir kitabın bir üye tarafından belirli bir tarihte
 * ödünç alınmasını temsil eder.
 */
public class Loan {

    // Ödünç alınan kitabı temsil eden değişken
    private Book book;

    // Kitabı ödünç alan üyeyi temsil eden değişken
    private Member member;

    // Kitabın ödünç alındığı tarihi tutan değişken
    private LocalDate borrowDate;

    // Kitabın iade edildiği tarihi tutan değişken
    private LocalDate returnDate;

    /**
     * Loan sınıfı için kurucu metot
     * Ödünç alma tarihi dışarıdan parametre olarak alınır.
     *
     * @param book Ödünç alınan kitap
     * @param member Kitabı alan üye
     * @param borrowDate Ödünç alma tarihi
     */
    public Loan(Book book, Member member, LocalDate borrowDate) {

        // Kitap bilgisi atanır
        this.book = book;

        // Üye bilgisi atanır
        this.member = member;

        // Ödünç alma tarihi atanır
        this.borrowDate = borrowDate;

        // İade tarihi başlangıçta boş olarak ayarlanır
        this.returnDate = null;
    }

    /**
     * Loan sınıfı için ikinci kurucu metot
     * Ödünç alma tarihi otomatik olarak bugünün tarihi atanır.
     *
     * @param book Ödünç alınan kitap
     * @param member Kitabı alan üye
     */
    public Loan(Book book, Member member) {

        // Kitap bilgisi atanır
        this.book = book;

        // Üye bilgisi atanır
        this.member = member;

        // Ödünç alma tarihi bugünün tarihi olarak atanır
        this.borrowDate = LocalDate.now();

        // İade tarihi başlangıçta boş olarak ayarlanır
        this.returnDate = null;
    }

    /**
     * Kitabın iade edilmesini sağlar
     * İade tarihi bugünün tarihi olarak atanır.
     */
    public void returnBook() {

        // İade tarihi bugünün tarihi olarak ayarlanır
        this.returnDate = LocalDate.now();
    }

    /**
     * Ödünç alınan kitabı döndürür.
     *
     * @return book
     */
    public Book getBook() {

        // Kitap nesnesi geri döndürülür
        return book;
    }

    /**
     * Kitabı ödünç alan üyeyi döndürür.
     *
     * @return member
     */
    public Member getMember() {

        // Üye nesnesi geri döndürülür
        return member;
    }

    /**
     * Kitabın ödünç alındığı tarihi döndürür.
     *
     * @return borrowDate
     */
    public LocalDate getBorrowDate() {

        // Ödünç alma tarihi geri döndürülür
        return borrowDate;
    }

    /**
     * Kitabın iade edildiği tarihi döndürür.
     *
     * @return returnDate
     */
    public LocalDate getReturnDate() {

        // İade tarihi geri döndürülür
        return returnDate;
    }

    /**
     * İade tarihini manuel olarak ayarlamak için kullanılır.
     *
     * @param returnDate İade tarihi
     */
    public void setReturnDate(LocalDate returnDate) {

        // İade tarihi dışarıdan gelen değerle güncellenir
        this.returnDate = returnDate;
    }
}
