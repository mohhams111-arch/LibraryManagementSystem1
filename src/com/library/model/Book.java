// Model (veri) sınıflarının bulunduğu paket
package com.library.model;

/**
 * Book sınıfı
 * Kütüphanedeki kitap bilgilerini temsil eder.
 */
public class Book {

    // Kitabın benzersiz kimlik numarasını tutan değişken
    private int id;

    // Kitabın adını tutan değişken
    private String title;

    // Kitabın yazarını tutan değişken
    private String author;

    // Kitabın ISBN numarasını tutan değişken
    private String isbn;

    // Kitabın müsait olup olmadığını gösteren değişken
    private boolean available;

    /**
     * Book sınıfı için kurucu metot
     *
     * @param id Kitabın kimlik numarası
     * @param title Kitabın adı
     * @param author Kitabın yazarı
     * @param isbn Kitabın ISBN numarası
     */
    public Book(int id, String title, String author, String isbn) {

        // Kitap kimliği atanır
        this.id = id;

        // Kitap adı atanır
        this.title = title;

        // Kitap yazarı atanır
        this.author = author;

        // ISBN numarası atanır
        this.isbn = isbn;

        // Kitap başlangıçta müsait olarak ayarlanır
        this.available = true;
    }

    /**
     * Kitabın kimlik numarasını döndürür
     *
     * @return id
     */
    public int getId() {

        // Kitap kimliği geri döndürülür
        return id;
    }

    /**
     * Kitabın mevcut (müsait) olup olmadığını döndürür
     *
     * @return available
     */
    public boolean isAvailable() {

        // Kitabın durumu geri döndürülür
        return available;
    }

    /**
     * Kitabın durumunu ayarlar
     *
     * @param available Kitabın müsaitlik durumu
     */
    public void setAvailable(boolean available) {

        // Kitabın durumu güncellenir
        this.available = available;
    }

    /**
     * Kitabın adını döndürür
     *
     * @return title
     */
    public String getTitle() {

        // Kitap adı geri döndürülür
        return title;
    }

    /**
     * Kitabın yazarını döndürür
     *
     * @return author
     */
    public String getAuthor() {

        // Kitap yazarı geri döndürülür
        return author;
    }

    /**
     * Kitabın ISBN numarasını döndürür
     *
     * @return isbn
     */
    public String getIsbn() {

        // ISBN numarası geri döndürülür
        return isbn;
    }
}
