package com.library.service;

import java.util.ArrayList;
import java.util.List;

import com.library.interfaces.Searchable;
import com.library.model.Book;
import com.library.model.Loan;
import com.library.model.Member;

/**
 * LibraryManager sınıfı, kütüphane sisteminin ana yönetim sınıfıdır.
 * Kitapların, üyelerin ve ödünç alma işlemlerinin yönetilmesini sağlar.
 * Ayrıca Searchable arayüzünü uygulayarak arama işlevi sunar.
 */
public class LibraryManager implements Searchable {

    /** Kütüphanedeki kitapların listesi */
    private List<Book> books;

    /** Kütüphaneye kayıtlı üyelerin listesi */
    private List<Member> members;

    /** Ödünç alınan kitapları temsil eden loan kayıtları */
    private List<Loan> loans;

    /**
     * LibraryManager sınıfı için kurucu metot.
     * Kitap, üye ve ödünç listelerini başlatır.
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
     * Sistemden bir kitabı kaldırır.
     *
     * @param book kaldırılacak kitap
     */
    public void removeBook(Book book) {
        books.remove(book);
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
     * Bir üyenin kitap ödünç almasını sağlar.
     * Kitap müsaitse ödünç alma işlemi gerçekleştirilir.
     *
     * @param book   ödünç alınacak kitap
     * @param member kitabı ödünç alan üye
     */
    public void borrowBook(Book book, Member member) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            loans.add(new Loan(book, member));
        }
    }

    /**
     * Bir kitabın iade edilmesini sağlar.
     *
     * @param book   iade edilecek kitap
     * @param member kitabı iade eden üye
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
     * Kütüphanede şu anda müsait olan kitapları listeler.
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
     * @param keyword arama anahtar kelimesi
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
