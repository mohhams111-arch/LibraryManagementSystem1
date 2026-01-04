package com.library.ui;

import com.library.model.Book;
import com.library.model.Member;
import com.library.service.LibraryManager;

/**
 * Programın başlangıç noktasıdır.
 */
public class Main {

    /**
     * Ana metot.
     */
    public static void main(String[] args) {

        LibraryManager libraryManager = new LibraryManager();

        Book book1 = new Book(1, "Java Programming", "James Gosling");
        Book book2 = new Book(2, "Clean Code", "Robert C. Martin");

        Member member1 = new Member(1, "Ali");

        libraryManager.addBook(book1);
        libraryManager.addBook(book2);
        libraryManager.addMember(member1);

        libraryManager.borrowBook(book1, member1);
        libraryManager.showAvailableBooks();
    }
}
