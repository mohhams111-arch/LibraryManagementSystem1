package com.library.ui;

import com.library.model.Book;
import com.library.model.Loan;
import com.library.model.Member;
import com.library.model.StudentMember;
import com.library.service.LibraryManager;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Main sınıfı, kütüphane sistemi için
 * kullanıcıdan alınan bilgilerle
 * kitap ödünç alma işlemlerini gerçekleştirir.
 */
public class Main {

    /**
     * Programın başlangıç noktasıdır.
     *
     * @param args komut satırı argümanları
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LibraryManager libraryManager = new LibraryManager();
        boolean devam = true;

        while (devam) {

            // ========= ÖĞRENCİ BİLGİLERİ =========

            System.out.print("Öğrenci adı: ");
            String studentName = scanner.nextLine();

            System.out.print("Öğrenci numarası: ");
            String studentNumber = scanner.nextLine();

            Member member = new StudentMember(1, studentName, studentNumber);
            libraryManager.addMember(member);

            // ========= KİTAP BİLGİLERİ =========

            System.out.print("Kitap adı: ");
            String bookTitle = scanner.nextLine();

            Book book = new Book(1, bookTitle, "Bilinmiyor", "000");
            libraryManager.addBook(book);

            // ========= TARİH BİLGİLERİ =========

            System.out.print("Ödünç alma tarihi (YYYY-MM-DD): ");
            LocalDate borrowDate = LocalDate.parse(scanner.nextLine());

            System.out.print("İade tarihi (YYYY-MM-DD): ");
            LocalDate returnDate = LocalDate.parse(scanner.nextLine());

            // ========= KÜTÜPHANE İŞLEMLERİ =========

            libraryManager.borrowBook(book, member, borrowDate);
            libraryManager.returnBook(book, returnDate);

            Loan loan = libraryManager.getLoans().get(
                    libraryManager.getLoans().size() - 1
            );

            // ========= HESAPLAMALAR =========

            long toplamGun = ChronoUnit.DAYS.between(
                    loan.getBorrowDate(),
                    loan.getReturnDate()
            );

            int izinliGun = 7;
            long gecikmeGun = toplamGun - izinliGun;

            if (gecikmeGun < 0) {
                gecikmeGun = 0;
            }

            double ceza = gecikmeGun * 2.5;

            // ========= SONUÇ =========

            System.out.println("\n--- SONUÇ ---");
            System.out.println("Öğrenci: " + studentName);
            System.out.println("Öğrenci No: " + studentNumber);
            System.out.println("Kitap: " + bookTitle);
            System.out.println("Toplam ödünç günü: " + toplamGun);
            System.out.println("Gecikme günü: " + gecikmeGun);
            System.out.println("Ceza: " + ceza + " TL");

            // ========= DEVAM =========

            System.out.print("\nYeni işlem yapmak ister misiniz? (E/H): ");
            String cevap = scanner.nextLine();

            if (cevap.equalsIgnoreCase("H")) {
                devam = false;
            }

            System.out.println();
        }

        scanner.close();
        System.out.println("Program sonlandırıldı.");
    }
}
