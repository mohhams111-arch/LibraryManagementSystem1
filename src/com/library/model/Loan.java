package com.library.model;

import java.time.LocalDate;

/**
 * Bu sınıf, bir kitabın bir üye tarafından ödünç alınmasını temsil eder.
 * Ödünç alma ve iade tarihlerini ve gecikme durumunu içerir.
 */
public class Loan {

    private Book book;
    private Member member;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    /**
     * Loan sınıfı için kurucu metot.
     *
     * @param book Ödünç alınan kitap
     * @param member Kitabı ödünç alan üye
     */
    public Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.borrowDate = LocalDate.now();
        this.returnDate = null;
    }

    /**
     * Kitabın iade edilmesini sağlar.
     */
    public void returnBook() {
        this.returnDate = LocalDate.now();
        book.setAvailable(true);
    }

    /**
     * Gecikme gün sayısını hesaplar.
     *
     * @return Geciken gün sayısı
     */
    public int calculateLateDays() {
        if (returnDate == null) {
            return 0;
        }
        int allowedDays = 14;
        int usedDays = borrowDate.until(returnDate).getDays();
        return Math.max(0, usedDays - allowedDays);
    }

    /**
     * Gecikme ücretini hesaplar.
     *
     * @return Gecikme ücreti
     */
    public double calculateFee() {
        int lateDays = calculateLateDays();
        return lateDays * 1.5;
    }
}
