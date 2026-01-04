package com.library.test;

import com.library.model.Book;
import com.library.model.Member;
import com.library.model.Loan;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

//JUnit doğrulama metotlarının içe aktarılması
import static org.junit.jupiter.api.Assertions.*;

//Test anotasyonunun içe aktarılması
import org.junit.jupiter.api.Test;

//Tarih işlemleri için LocalDate sınıfının içe aktarılması
import java.time.LocalDate;

/**
* Kütüphane sistemi için genel birim test sınıfı
* Bu sınıf, Book, Member ve Loan sınıflarının temel işlevlerini test eder
*/
public class LibrarySystemTest {

 // Book sınıfının doğru şekilde oluşturulup oluşturulmadığını test eder
 @Test
 void testBookCreation() {

     // Yeni bir kitap nesnesi oluşturulur
     Book book = new Book(1, "Clean Code", "Robert C. Martin", "123456");

     // Kitap ID değerinin doğru atanıp atanmadığı kontrol edilir
     assertEquals(1, book.getId());

     // Kitap başlığının doğru atanıp atanmadığı kontrol edilir
     assertEquals("Clean Code", book.getTitle());

     // Kitabın başlangıçta müsait olup olmadığı kontrol edilir
     assertTrue(book.isAvailable());
 }

 // Member sınıfının doğru şekilde oluşturulup oluşturulmadığını test eder
 @Test
 void testMemberCreation() {

     // Yeni bir üye nesnesi oluşturulur
     Member member = new Member(1, "Ali");

     // Üye ID değerinin doğru atanıp atanmadığı kontrol edilir
     assertEquals(1, member.getId());

     // Üye adının doğru atanıp atanmadığı kontrol edilir
     assertEquals("Ali", member.getName());
 }

 // Loan sınıfında ödünç alma ve iade işlemlerinin doğru çalıştığını test eder
 @Test
 void testLoanProcess() {

     // Test için bir kitap nesnesi oluşturulur
     Book book = new Book(2, "Java", "James Gosling", "654321");

     // Test için bir üye nesnesi oluşturulur
     Member member = new Member(2, "Veli");

     // Kitap 3 gün önce ödünç alınmış gibi Loan nesnesi oluşturulur
     Loan loan = new Loan(book, member, LocalDate.now().minusDays(3));

     // Kitap iade edilir
     loan.returnBook();

     // Ödünç alma tarihinin null olmadığı kontrol edilir
     assertNotNull(loan.getBorrowDate());

     // İade tarihinin null olmadığı kontrol edilir
     assertNotNull(loan.getReturnDate());
 }
}

