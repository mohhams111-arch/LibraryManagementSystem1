package com.library.ui;

import com.library.model.Book;
import com.library.model.Loan;
import com.library.model.Member;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Main sınıfı, kütüphane sistemi için kullanıcı arayüzünü temsil eder.
 * Kullanıcıdan üye bilgileri, kitap bilgileri ve tarih bilgileri alınır.
 * Girilen bilgilere göre ödünç alma süresi hesaplanır ve
 * gecikme durumunda ceza tutarı belirlenir.
 */
public class Main {

    /**
     * Programın başlangıç noktasıdır.
     * Kullanıcı ile etkileşim kurarak ödünç alma ve iade işlemlerini simüle eder.
     *
     * @param args komut satırı argümanları
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean devam = true;

        // Program kullanıcı çıkış yapana kadar çalışır
        while (devam) {

            // Üye adı alınır
            System.out.print("Üye adını giriniz (Ali / Mart): ");
            String memberName = scanner.nextLine();

            Member member = null;

            // Sistem sadece tanımlı üyeleri kabul eder
            if (memberName.equalsIgnoreCase("Ali")) {
                member = new Member(1, "Ali");
            } else if (memberName.equalsIgnoreCase("Mart")) {
                member = new Member(2, "Mart");
            } else {
                System.out.println("❌ Bu üyenin sistemde hesabı yok.");
                continue;
            }

            // Kitap adı alınır
            System.out.print("Kitap adını giriniz (Suc / Madonna): ");
            String bookTitle = scanner.nextLine();

            Book book = null;

            // Sistem sadece tanımlı kitapları kabul eder
            if (bookTitle.equalsIgnoreCase("Suc")) {
                book = new Book(1, "Suc", "Author1", "111");
            } else if (bookTitle.equalsIgnoreCase("Madonna")) {
                book = new Book(2, "Madonna", "Author2", "222");
            } else {
                System.out.println("❌ Bu kitap sistemde mevcut değil.");
                continue;
            }

            // Ödünç alma tarihi alınır
            System.out.print("Ödünç alma tarihi (YYYY-MM-DD): ");
            LocalDate borrowDate = LocalDate.parse(scanner.nextLine());

            // İade tarihi alınır
            System.out.print("İade tarihi (YYYY-MM-DD): ");
            LocalDate returnDate = LocalDate.parse(scanner.nextLine());

            // Loan nesnesi oluşturulur
            Loan loan = new Loan(book, member, borrowDate);
            loan.setReturnDate(returnDate);

            // Toplam ödünç gün sayısı hesaplanır
            long toplamGun = ChronoUnit.DAYS.between(
                    loan.getBorrowDate(),
                    loan.getReturnDate()
            );

            // Gecikme ve ceza hesaplaması
            int izinliGun = 7;
            long gecikmeGun = toplamGun - izinliGun;

            if (gecikmeGun < 0) {
                gecikmeGun = 0;
            }

            double ceza = gecikmeGun * 2.5;

            // Sonuçlar ekrana yazdırılır
            System.out.println("\n--- SONUÇ ---");
            System.out.println("Üye: " + member.getName());
            System.out.println("Kitap: " + book.getTitle());
            System.out.println("Toplam gün sayısı: " + toplamGun);
            System.out.println("Gecikme gün sayısı: " + gecikmeGun);
            System.out.println("Ceza: " + ceza + " TL");

            // Yeni işlem kontrolü
            System.out.print("\nYeni bir işlem yapmak ister misiniz? (E/H): ");
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
