package com.library.model;

import java.time.LocalDate;

/**
 * Loan sınıfı, bir kitabın bir üye tarafından
 * belirli bir tarihte ödünç alınmasını temsil eder.
 */
public class Loan {

    private Book book;
    private Member member;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    /**
     * Loan constructor
     *
     * @param book ödünç alınan kitap
     * @param member kitabı alan üye
     * @param borrowDate ödünç alma tarihi
     */
    public Loan(Book book, Member member, LocalDate borrowDate) {
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.returnDate = null;
    }

    /**
     * Loan constructor (ödünç alma tarihi otomatik atanır)
     *
     * @param book ödünç alınan kitap
     * @param member kitabı alan üye
     */
    public Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.borrowDate = LocalDate.now();
        this.returnDate = null;
    }

    /**
     * Kitabın iade edilmesini sağlar
     */
    public void returnBook() {
        this.returnDate = LocalDate.now();
    }

    /**
     * Ödünç alınan kitabı döndürür
     *
     * @return book
     */
    public Book getBook() {
        return book;
    }

    /**
     * Kitabı alan üyeyi döndürür
     *
     * @return member
     */
    public Member getMember() {
        return member;
    }

    /**
     * Ödünç alma tarihini döndürür
     *
     * @return borrowDate
     */
    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    /**
     * İade tarihini döndürür
     *
     * @return returnDate
     */
    public LocalDate getReturnDate() {
        return returnDate;
    }

    /**
     * İade tarihini manuel olarak ayarlar
     *
     * @param returnDate iade tarihi
     */
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
