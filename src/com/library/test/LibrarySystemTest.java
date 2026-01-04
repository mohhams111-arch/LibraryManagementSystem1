package com.library.test;

import com.library.model.Book;
import com.library.model.Member;
import com.library.model.Loan;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Kütüphane sistemi için genel birim testleri
 */
public class LibrarySystemTest {

    @Test
    void testBookCreation() {
        Book book = new Book(1, "Clean Code", "Robert C. Martin", "123456");

        assertEquals(1, book.getId());
        assertEquals("Clean Code", book.getTitle());
        assertTrue(book.isAvailable());
    }

    @Test
    void testMemberCreation() {
        Member member = new Member(1, "Ali");

        assertEquals(1, member.getId());
        assertEquals("Ali", member.getName());
    }

    @Test
    void testLoanProcess() {
        Book book = new Book(2, "Java", "James Gosling", "654321");
        Member member = new Member(2, "Veli");

        Loan loan = new Loan(book, member, LocalDate.now().minusDays(3));
        loan.returnBook();

        assertNotNull(loan.getBorrowDate());
        assertNotNull(loan.getReturnDate());
    }
}
