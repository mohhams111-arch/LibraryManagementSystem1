package com.library.interfaces;

import java.util.List;
import com.library.model.Book;

/**
 * Bu arayüz, kitaplar üzerinde arama yapılmasını sağlar.
 */
public interface Searchable {

    /**
     * Verilen anahtar kelimeye göre kitapları arar.
     *
     * @param keyword Arama anahtar kelimesi
     * @return Bulunan kitapların listesi
     */
    List<Book> search(String keyword);
}
