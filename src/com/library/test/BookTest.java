package com.library.test;

import com.library.model.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Book sınıfı için birim testleri
 */
public class BookTest {

    @Test
    void testBookCreation() {
        Book book = new Book(1, "Clean Code", "Robert C. Martin", "123456");

        assertEquals(1, book.getId());
        assertEquals("Clean Code", book.getTitle());
        assertEquals("Robert C. Martin", book.getAuthor());
        assertEquals("123456", book.getIsbn());
        assertTrue(book.isAvailable());
    }

    @Test
    void testBookAvailabilityChange() {
        Book book = new Book(2, "Java", "James Gosling", "654321");
        book.setAvailable(false);

        assertFalse(book.isAvailable());
    }
}
