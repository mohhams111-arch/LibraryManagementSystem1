package com.library.ui;

import com.library.model.Book;
import com.library.model.Loan;
import com.library.model.Member;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean devam = true;

        while (devam) {

            System.out.print("Üye adını giriniz (Ali /Mart): ");
            String memberName = scanner.nextLine();

            Member member = null;

            if (memberName.equalsIgnoreCase("Ali")) {
                member = new Member(1, "Ali");
            } else if (memberName.equalsIgnoreCase("Mart")) {
                member = new Member(2, "Mart");
            } else {
                System.out.println("❌ Bu üyenin sistemde hesabı yok.");
                continue;
            }

            System.out.print("Kitap adını giriniz (Suc / Madonna): ");
            String bookTitle = scanner.nextLine();

            Book book = null;

            if (bookTitle.equalsIgnoreCase("Suc")) {
                book = new Book(1, "Suc", "Author1", "111");
            } else if (bookTitle.equalsIgnoreCase("Madonna")) {
                book = new Book(2, "Madonna", "Author2", "222");
            } else {
                System.out.println("❌ Bu kitap sistemde mevcut değil.");
                continue;
            }

      
            System.out.print("Ödünç alma tarihi (YYYY-MM-DD): ");
            LocalDate borrowDate = LocalDate.parse(scanner.nextLine());

         
            System.out.print("İade tarihi (YYYY-MM-DD): ");
            LocalDate returnDate = LocalDate.parse(scanner.nextLine());

            
            Loan loan = new Loan(book, member, borrowDate);
            loan.setReturnDate(returnDate);

            
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

           
            System.out.println("\n--- SONUÇ ---");
            System.out.println("Üye: " + member.getName());
            System.out.println("Kitap: " + book.getTitle());
            System.out.println("Toplam gün sayısı: " + toplamGun);
            System.out.println("Gecikme gün sayısı: " + gecikmeGun);
            System.out.println("Ceza: " + ceza + " TL");

       
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
