// Model (veri) sınıflarının bulunduğu paket
package com.library.model;

/**
 * Book sınıfı, kütüphanede bulunan bir kitabın
 * temel bilgilerini ve durumunu temsil eder.
 * Her kitap benzersiz bir kimliğe sahiptir ve
 * ödünç alınma durumuna göre takip edilir.
 */
public class Book {

    // Kitabın benzersiz kimlik numarası
    private int id;

    // Kitabın başlığı
    private String title;

    // Kitabın yazarı
    private String author;

    // Kitabın ISBN numarası
    private String isbn;

    // Kitabın müsait olup olmadığını belirtir
    private boolean available;

    /**
     * Book sınıfı için kurucu metot.
     * Yeni oluşturulan kitap varsayılan olarak
     * müsait (available) kabul edilir.
     *
     * @param id kitabın kimlik numarası
     * @param title kitabın adı
     * @param author kitabın yazarı
     * @param isbn kitabın ISBN numarası
     */
    public Book(int id, String title, String author, String isbn) {

        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
    }

    /**
     * Kitabın kimlik numarasını döndürür.
     *
     * @return kitap ID değeri
     */
    public int getId() {

        return id;
    }

    /**
     * Kitabın şu anda müsait olup olmadığını döndürür.
     *
     * @return true ise kitap müsaittir, false ise ödünç alınmıştır
     */
    public boolean isAvailable() {

        return available;
    }

    /**
     * Kitabın müsaitlik durumunu ayarlar.
     *
     * @param available kitabın yeni durumu
     */
    public void setAvailable(boolean available) {

        this.available = available;
    }

    /**
     * Kitabın başlığını döndürür.
     *
     * @return kitap adı
     */
    public String getTitle() {

        return title;
    }

    /**
     * Kitabın yazar adını döndürür.
     *
     * @return kitap yazarı
     */
    public String getAuthor() {

        return author;
    }

    /**
     * Kitabın ISBN numarasını döndürür.
     *
     * @return ISBN numarası
     */
    public String getIsbn() {

        return isbn;
    }
}
