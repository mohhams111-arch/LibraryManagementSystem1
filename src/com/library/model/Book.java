package com.library.model;

/**
 * Book sınıfı, kütüphanedeki kitap bilgilerini temsil eder.
 */
public class Book {

    private int id;
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    /**
     * Book constructor
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
     * Kitabın ID bilgisini döndürür
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Kitabın mevcut olup olmadığını döndürür
     *
     * @return available
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Kitabın durumunu ayarlar
     *
     * @param available kitabın durumu
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Kitabın adını döndürür
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Kitabın yazarını döndürür
     *
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Kitabın ISBN numarasını döndürür
     *
     * @return isbn
     */
    public String getIsbn() {
        return isbn;
    }
}
