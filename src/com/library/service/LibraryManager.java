package com.library.service;

import java.util.ArrayList;
import java.util.List;

import com.library.interfaces.Searchable;
import com.library.model.Book;
import com.library.model.Loan;
import com.library.model.Member;
import com.library.model.StudentMember;

import java.time.LocalDate;

/**
 * LibraryManager sınıfı, kütüphane sisteminin
 * ana yönetim sınıfıdır.
 *
 * Kitap, üye ve ödünç alma işlemlerini yönetir
 * ve arama işlevi sunar.
 */
public class LibraryManager implements Searchable {

    /** Kütüphanedeki kitapların listesi */
    private List<Book> books;

    /** Kütüphaneye kayıtlı üyelerin listesi */
    private List<Member> members;

    /** Aktif ödünç alma işlemlerini tutan liste */
    private List<Loan> loans;

    /**
     * LibraryManager sınıfı için kurucu metot.
     */
    public LibraryManager() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    /**
     * Sisteme yeni bir kitap ekler.
     *
     * @param book eklenecek kitap
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Sisteme yeni bir üye ekler.
     *
     * @param member eklenecek üye
     */
    public void addMember(Member member) {
        members.add(member);
    }

    /**
     * Sisteme yeni bir öğrenci üye ekler.
     *
     * @param student eklenecek öğrenci
     */
    public void addStudent(StudentMember student) {
        members.add(student);
    }

    /**
     * Bir üyenin kitap ödünç almasını sağlar.
     *
     * @param book ödünç alınacak kitap
     * @param member kitabı alan üye
     * @param borrowDate ödünç alma tarihi
     */
    public void borrowBook(Book book, Member member, LocalDate borrowDate) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            loans.add(new Loan(book, member, borrowDate));
        }
    }

    /**
     * Bir kitabın iade edilmesini sağlar.
     *
     * @param book iade edilecek kitap
     * @param returnDate iade tarihi
     */
    public void returnBook(Book book, LocalDate returnDate) {
        for (Loan loan : loans) {
            if (loan.getBook().equals(book) && loan.getReturnDate() == null) {
                loan.setReturnDate(returnDate);
                book.setAvailable(true);
                break;
            }
        }
    }

    /**
     * Sistemde kayıtlı tüm üyeleri döndürür.
     *
     * @return üye listesi
     */
    public List<Member> getMembers() {
        return members;
    }

    /**
     * Sistemde kayıtlı tüm kitapları döndürür.
     *
     * @return kitap listesi
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Aktif ödünç alma işlemlerini döndürür.
     *
     * @return loan listesi
     */
    public List<Loan> getLoans() {
        return loans;
    }

    /**
     * Kütüphanede müsait olan kitapları ekrana yazdırır.
     */
    public void showAvailableBooks() {
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle());
            }
        }
    }

    /**
     * Başlık veya yazar adına göre kitap araması yapar.
     *
     * @param keyword arama kelimesi
     * @return bulunan kitapların listesi
     */
    @Override
    public List<Book> search(String keyword) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())
                    || book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }
}
