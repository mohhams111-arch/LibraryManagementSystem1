// yardımcı (utility) sınıfların bulunduğu paket
package com.library.util;

// Dosyaya yazma işlemleri için FileWriter sınıfı
import java.io.FileWriter;

// Giriş/çıkış hatalarını yakalamak için IOException
import java.io.IOException;

// Liste yapısını kullanmak için List arayüzü
import java.util.List;

// Book sınıfının içe aktarılması
import com.library.model.Book;

// Loan sınıfının içe aktarılması
import com.library.model.Loan;

/**
 * FileManager sınıfı
 * Kitap ve ödünç (loan) bilgilerini metin dosyalarına
 * kaydetmek için kullanılan yardımcı sınıftır.
 */
public class FileManager {

    /**
     * Kitap listesini "books.txt" dosyasına kaydeder.
     *
     * @param books Dosyaya yazılacak kitap listesi
     */
    public void saveBooks(List<Book> books) {

        // FileWriter ile books.txt dosyası açılır (try-with-resources)
        try (FileWriter writer = new FileWriter("books.txt")) {

            // Kitap listesi üzerinde döngü başlatılır
            for (Book book : books) {

                // Her kitabın id, başlık ve yazar bilgisi dosyaya yazılır
                writer.write(
                        book.getId() + "," +
                        book.getTitle() + "," +
                        book.getAuthor() + "\n"
                );
            }

        // Dosya yazma sırasında oluşabilecek hatalar yakalanır
        } catch (IOException e) {

            // Hata detayları konsola yazdırılır
            e.printStackTrace();
        }
    }

    /**
     * Ödünç alınan kitapları "loans.txt" dosyasına kaydeder.
     *
     * @param loans Dosyaya yazılacak ödünç listesi
     */
    public void saveLoans(List<Loan> loans) {

        // FileWriter ile loans.txt dosyası açılır
        try (FileWriter writer = new FileWriter("loans.txt")) {

            // Ödünç listesi üzerinde döngü başlatılır
            for (Loan loan : loans) {

                // Loan nesnesinin string çıktısı dosyaya yazılır
                writer.write(loan.toString() + "\n");
            }

        // Dosya işlemleri sırasında oluşabilecek hatalar yakalanır
        } catch (IOException e) {

            // Hata bilgileri konsola yazdırılır
            e.printStackTrace();
        }
    }
}
