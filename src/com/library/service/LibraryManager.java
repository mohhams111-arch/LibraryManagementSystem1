package com.library.service;

import java.util.ArrayList;
import java.util.List;

import com.library.interfaces.Searchable;
import com.library.model.Book;
import com.library.model.Loan;
import com.library.model.Member;

/**
 * Bu sınıf, kütüphanenin genel yönetimini sağlar.
 * Kitaplar, üyeler ve ödünç işlemleri bu sınıf üzerinden yönetilir.
 */
public class LibraryManager implements Searchable {

    private List<Book> books;
    private List<Member> members;
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
     * Kütüphaneye yeni kitap ekler.
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Kütüphaneden kitap siler.
     */
    public void removeBook(Book book) {
        books.remove(book);
    }

    /**
     * Kütüphaneye yeni üye ekler.
     */
    public void addMember(Member member) {
        members.add(member);
    }

    /**
     * Bir üyenin kitap ödünç almasını sağlar.
     */
    public void borrowBook(Book book, Member member) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            loans.add(new Loan(book, member));
        }
    }

    /**
     * Bir kitabın iade edilmesini sağlar.
     */
    public void returnBook(Book book, Member member) {
        for (Loan loan : loans) {
            if (loan != null) {
                loan.returnBook();
                break;
            }
        }
    }

    /**
     * Müsait kitapları ekrana yazdırır.
     */
    public void showAvailableBooks() {
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle());
            }
        }
    }

    /**
     * Anahtar kelimeye göre kitap arar.
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
