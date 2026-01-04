package com.library.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.library.model.Book;
import com.library.model.Loan;

/**
 * Bu sınıf, kitap ve ödünç bilgilerini dosyaya kaydetmek için kullanılır.
 */
public class FileManager {

    /**
     * Kitap listesini dosyaya kaydeder.
     *
     * @param books Kaydedilecek kitap listesi
     */
    public void saveBooks(List<Book> books) {
        try (FileWriter writer = new FileWriter("books.txt")) {
            for (Book book : books) {
                writer.write(book.getId() + "," + book.getTitle() + "," + book.getAuthor() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ödünç alınan kitapları dosyaya kaydeder.
     *
     * @param loans Kaydedilecek ödünç listesi
     */
    public void saveLoans(List<Loan> loans) {
        try (FileWriter writer = new FileWriter("loans.txt")) {
            for (Loan loan : loans) {
                writer.write(loan.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
