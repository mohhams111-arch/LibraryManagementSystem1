// Arayüzlerin (interfaces) bulunduğu paket
package com.library.interfaces;

// Liste yapısını kullanmak için List arayüzü
import java.util.List;

// Kitap modeli sınıfı
import com.library.model.Book;

/**
 * Searchable arayüzü
 * Kitaplar üzerinde arama yapılmasını sağlayan metodu tanımlar.
 */
public interface Searchable {

    /**
     * Verilen anahtar kelimeye göre kitap arama işlemi yapar.
     *
     * @param keyword Arama işlemi için kullanılacak anahtar kelime
     * @return Anahtar kelimeye uyan kitapların listesi
     */
    List<Book> search(String keyword);
}

