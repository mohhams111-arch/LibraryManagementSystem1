package com.library.model;

/**
 * Bu sınıf, kütüphanedeki bir kitabı temsil eder.
 * Her kitap bir kimlik numarası, başlık, yazar bilgisi
 * ve müsaitlik durumuna sahiptir.
 */
public class Book {

    private int id;
    private String title;
    private String author;
    private boolean available;

    /**
     * Book sınıfı için kurucu metot.
     *
     * @param id Kitap kimliği
     * @param title Kitap başlığı
     * @param author Kitap yazarı
     */
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    /**
     * Kitap kimliğini döndürür.
     */
    public int getId() {
        return id;
    }

    /**
     * Kitap başlığını döndürür.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Kitap yazarını döndürür.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Kitabın müsait olup olmadığını döndürür.
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Kitabın müsaitlik durumunu ayarlar.
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }
}
