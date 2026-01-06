package com.library.interfaces;

import java.util.List;
import com.library.model.Book;

/**
 * Searchable arayüzü, kitaplar üzerinde arama işlemlerini tanımlar.
 * Bu arayüzü uygulayan sınıflar, verilen anahtar kelimeye göre
 * kitap arama işlevini gerçekleştirmek zorundadır.
 */
public interface Searchable {

    /**
     * Verilen anahtar kelimeye göre kitapları arar.
     * Arama işlemi kitap adı veya yazar adı üzerinden yapılır.
     *
     * @param keyword arama için kullanılacak anahtar kelime
     * @return arama sonucunda bulunan kitapların listesi
     */
    List<Book> search(String keyword);
}
