// servis (service) katmanındaki sınıfların bulunduğu paket
package com.library.service;

// Dinamik liste yapısı için ArrayList sınıfı
import java.util.ArrayList;

// Liste arayüzünü kullanmak için List
import java.util.List;

// Arama işlemleri için Searchable arayüzü
import com.library.interfaces.Searchable;

// Kitap model sınıfı
import com.library.model.Book;

// Ödünç alma işlemleri için Loan sınıfı
import com.library.model.Loan;

// Üye model sınıfı
import com.library.model.Member;

/**
 * LibraryManager sınıfı
 * Kütüphanenin genel yönetimini sağlar.
 * Kitaplar, üyeler ve ödünç alma işlemleri bu sınıf üzerinden yapılır.
 */
public class LibraryManager implements Searchable {

    // Kütüphanedeki kitapların tutulduğu liste
    private List<Book> books;

    // Kütüphaneye kayıtlı üyelerin tutulduğu liste
    private List<Member> members;

    // Ödünç alınan kitapların tutulduğu liste
    private List<Loan> loans;

    /**
     * LibraryManager sınıfının kurucu metodu
     * Liste yapıları burada oluşturulur.
     */
    public LibraryManager() {

        // Kitap listesi başlatılır
        this.books = new ArrayList<>();

        // Üye listesi başlatılır
        this.members = new ArrayList<>();

        // Ödünç listesi başlatılır
        this.loans = new ArrayList<>();
    }

    /**
     * Kütüphaneye yeni bir kitap ekler.
     *
     * @param book Eklenecek kitap
     */
    public void addBook(Book book) {

        // Kitap listeye eklenir
        books.add(book);
    }

    /**
     * Kütüphaneden bir kitabı siler.
     *
     * @param book Silinecek kitap
     */
    public void removeBook(Book book) {

        // Kitap listeden çıkarılır
        books.remove(book);
    }

    /**
     * Kütüphaneye yeni bir üye ekler.
     *
     * @param member Eklenecek üye
     */
    public void addMember(Member member) {

        // Üye listeye eklenir
        members.add(member);
    }

    /**
     * Bir üyenin kitap ödünç almasını sağlar.
     *
     * @param book   Ödünç alınacak kitap
     * @param member Kitabı alan üye
     */
    public void borrowBook(Book book, Member member) {

        // Kitabın müsait olup olmadığı kontrol edilir
        if (book.isAvailable()) {

            // Kitap artık müsait değil olarak işaretlenir
            book.setAvailable(false);

            // Yeni bir ödünç kaydı oluşturulup listeye eklenir
            loans.add(new Loan(book, member));
        }
    }

    /**
     * Bir kitabın iade edilmesini sağlar.
     *
     * @param book   İade edilecek kitap
     * @param member Kitabı iade eden üye
     */
    public void returnBook(Book book, Member member) {

        // Ödünç listesi üzerinde döngü başlatılır
        for (Loan loan : loans) {

            // Loan nesnesinin boş olup olmadığı kontrol edilir
            if (loan != null) {

                // Kitap iade işlemi gerçekleştirilir
                loan.returnBook();

                // İlk eşleşmeden sonra döngü sonlandırılır
                break;
            }
        }
    }

    /**
     * Müsait olan kitapları ekrana yazdırır.
     */
    public void showAvailableBooks() {

        // Kitap listesi üzerinde döngü başlatılır
        for (Book book : books) {

            // Kitabın müsait olup olmadığı kontrol edilir
            if (book.isAvailable()) {

                // Kitabın başlığı ekrana yazdırılır
                System.out.println(book.getTitle());
            }
        }
    }

    /**
     * Anahtar kelimeye göre kitap arama işlemi yapar.
     * Başlık veya yazar adına göre arama yapılır.
     *
     * @param keyword Aranacak kelime
     * @return Bulunan kitapların listesi
     */
    @Override
    public List<Book> search(String keyword) {

        // Arama sonuçlarını tutacak liste oluşturulur
        List<Book> result = new ArrayList<>();

        // Kitap listesi üzerinde döngü başlatılır
        for (Book book : books) {

            // Kitap adı veya yazar adı anahtar kelimeyi içeriyor mu kontrol edilir
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())
                    || book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {

                // Eşleşen kitap sonuç listesine eklenir
                result.add(book);
            }
        }

        // Arama sonuçları geri döndürülür
        return result;
    }
}
