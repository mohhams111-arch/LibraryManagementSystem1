package com.library.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.library.model.Book;
import com.library.model.Loan;

/**
 * FileManager sınıfı, kütüphane sistemindeki verilerin
 * dosya tabanlı olarak saklanmasından sorumludur.
 * Kitap ve ödünç alma bilgileri metin dosyalarına yazılır.
 */
public class FileManager {

    /**
     * Verilen kitap listesini "books.txt" dosyasına kaydeder.
     * Her kitap satır bazlı olarak ID, başlık ve yazar bilgileriyle yazılır.
     *
     * @param books kaydedilecek kitap listesi
     */
    public void saveBooks(List<Book> books) {

        try (FileWriter writer = new FileWriter("books.txt")) {

            // Kitap listesi dosyaya yazılır
            for (Book book : books) {

                writer.write(
                        book.getId() + "," +
                        book.getTitle() + "," +
                        book.getAuthor() + "\n"
                );
            }

        } catch (IOException e) {

            // Dosya işlemleri sırasında oluşan hatalar yakalanır
            e.printStackTrace();
        }
    }

    /**
     * Verilen ödünç alma listesini "loans.txt" dosyasına kaydeder.
     * Her ödünç işlemi bir satır olacak şekilde yazılır.
     *
     * @param loans kaydedilecek ödünç alma listesi
     */
    public void saveLoans(List<Loan> loans) {

        try (FileWriter writer = new FileWriter("loans.txt")) {

            // Ödünç alma bilgileri dosyaya yazılır
            for (Loan loan : loans) {

                writer.write(loan.toString() + "\n");
            }

        } catch (IOException e) {

            // Dosya yazma hataları konsola yazdırılır
            e.printStackTrace();
        }
    }
}
