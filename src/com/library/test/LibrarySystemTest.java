package com.library.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

import com.library.model.Book;
import com.library.model.Member;
import com.library.model.Loan;

/**
 * Basit unit test sınıfı.
 */
public class LibrarySystemTest {

    /**
     * Kitap oluşturma testi.
     */
    @Test
    void testBookCreation() {

        Book book = new Book(1, "Clean Code", "Robert C. Martin", "123456");

        assertEquals(1, book.getId());
        assertEquals("Clean Code", book.getTitle());
        assertTrue(book.isAvailable());
    }

    /**
     * Üye oluşturma testi.
     */
    @Test
    void testMemberCreation() {

        Member member = new Member(1, "Ali");

        assertEquals(1, member.getId());
        assertEquals("Ali", member.getName());
    }

    /**
     * Ödünç alma süresi testi.
     */
    @Test
    void testLoanProcess() {

        Book book = new Book(2, "Java", "James Gosling", "654321");
        Member member = new Member(2, "Veli");

        LocalDate borrowDate = LocalDate.now().minusDays(10);
        LocalDate returnDate = LocalDate.now();

        Loan loan = new Loan(book, member, borrowDate);
        loan.setReturnDate(returnDate);

        long totalDays = ChronoUnit.DAYS.between(
                loan.getBorrowDate(),
                loan.getReturnDate()
        );

        assertEquals(10, totalDays);
    }
}
