package com.library.ui;

import com.library.model.Book;
import com.library.model.Loan;
import com.library.model.Member;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Programın çalıştırıldığı ana sınıf
 */
public class Main {

    public static void main(String[] args) {

    	Book book = new Book(1, "Clean Code", "Robert C. Martin", "123456");
        Member member = new Member(1, "Ali");
        
        Loan loan = new Loan(book, member, LocalDate.now().minusDays(10));

        // Kitabı iade et
        loan.returnBook();

        long gecikmeGunSayisi = ChronoUnit.DAYS.between(
                loan.getBorrowDate(),
                loan.getReturnDate()
        );

        double ceza = 0;
        if (gecikmeGunSayisi > 7) {
            ceza = (gecikmeGunSayisi - 7) * 2.5;
        }

        System.out.println("Üye: " + member.getName());
        System.out.println("Kitap: " + book.getTitle());
        System.out.println("Gecikme gün sayısı: " + gecikmeGunSayisi);
        System.out.println("Ceza: " + ceza + " TL");
    }
}
