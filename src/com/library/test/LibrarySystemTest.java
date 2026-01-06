// Test sınıflarının bulunduğu paket
package com.library.test;

// JUnit doğrulama metotları
import static org.junit.jupiter.api.Assertions.*;

// Tarih işlemleri için LocalDate
import java.time.LocalDate;

// JUnit test anotasyonu
import org.junit.jupiter.api.Test;

// Model sınıfları
import com.library.model.Book;
import com.library.model.Member;
import com.library.model.Loan;

/**
 * LibrarySystemTest sınıfı
 * Bu sınıf, kütüphane yönetim sistemindeki
 * temel model sınıflarının doğru çalışıp
 * çalışmadığını test etmek için kullanılır.
 */
public class LibrarySystemTest {

    /**
     * Book sınıfının doğru şekilde oluşturulup
     * oluşturulmadığını test eder.
     */
    @Test
    void testBookCreation() {

        // Test için kitap nesnesi oluşturulur
        Book book = new Book(1, "Clean Code", "Robert C. Martin", "123456");

        // Kitap ID değerinin doğru olduğu kontrol edilir
        assertEquals(1, book.getId());

        // Kitap başlığının doğru olduğu kontrol edilir
        assertEquals("Clean Code", book.getTitle());

        // Kitabın başlangıçta müsait olması beklenir
        assertTrue(book.isAvailable());
    }

    /**
     * Member sınıfının doğru şekilde oluşturulup
     * oluşturulmadığını test eder.
     */
    @Test
    void testMemberCreation() {

        // Test için üye nesnesi oluşturulur
        Member member = new Member(1, "Ali");

        // Üye ID değerinin doğru olduğu kontrol edilir
        assertEquals(1, member.getId());

        // Üye adının doğru olduğu kontrol edilir
        assertEquals("Ali", member.getName());
    }

    /**
     * Loan sınıfında ödünç alma ve iade işlemlerinin
     * doğru çalıştığını test eder.
     */
    @Test
    void testLoanProcess() {

        // Test için kitap nesnesi oluşturulur
        Book book = new Book(2, "Java", "James Gosling", "654321");

        // Test için üye nesnesi oluşturulur
        Member member = new Member(2, "Veli");

        // Kitap 3 gün önce ödünç alınmış gibi Loan nesnesi oluşturulur
        Loan loan = new Loan(book, member, LocalDate.now().minusDays(3));

        // Ödünç alma tarihinin boş olmadığı kontrol edilir
        assertNotNull(loan.getBorrowDate());

        // Kitap iade edilir
        loan.returnBook();

        // İade tarihinin boş olmadığı kontrol edilir
        assertNotNull(loan.getReturnDate());
    }
}
