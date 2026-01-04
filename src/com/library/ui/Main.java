// Kullanıcı arayüzü (UI) paketini tanımlar
package com.library.ui;

// Kitap sınıfını kullanabilmek için import edilir
import com.library.model.Book;

// Ödünç alma (Loan) sınıfını kullanabilmek için import edilir
import com.library.model.Loan;

// Üye (Member) sınıfını kullanabilmek için import edilir
import com.library.model.Member;

// Tarih işlemleri için LocalDate sınıfı import edilir
import java.time.LocalDate;

// İki tarih arasındaki gün farkını hesaplamak için ChronoUnit import edilir
import java.time.temporal.ChronoUnit;

// Programın çalıştırıldığı ana sınıf
public class Main {

    // Java programının başlangıç noktası
    public static void main(String[] args) {

        // ID'si 1 olan, adı "Clean Code", yazarı ve ISBN numarası olan bir kitap oluşturulur
        Book book = new Book(1, "Clean Code", "Robert C. Martin", "123456");

        // ID'si 1 olan ve adı "Ali" olan bir üye oluşturulur
        Member member = new Member(1, "Ali");

        // Kitabın 10 gün önce ödünç alındığını varsayan bir Loan nesnesi oluşturulur
        Loan loan = new Loan(book, member, LocalDate.now().minusDays(10));

        // Kitap iade edilir ve iade tarihi atanır
        loan.returnBook();

        // Ödünç alma tarihi ile iade tarihi arasındaki gecikme gün sayısı hesaplanır
        long gecikmeGunSayisi = ChronoUnit.DAYS.between(
                loan.getBorrowDate(),
                loan.getReturnDate()
        );

        // Ceza değişkeni başlangıçta 0 olarak tanımlanır
        double ceza = 0;

        // Eğer gecikme süresi 7 günden fazlaysa
        if (gecikmeGunSayisi > 7) {

            // 7 günden sonraki her gün için 2.5 TL ceza hesaplanır
            ceza = (gecikmeGunSayisi - 7) * 2.5;
        }

        // Üyenin adı ekrana yazdırılır
        System.out.println("Üye: " + member.getName());

        // Kitabın adı ekrana yazdırılır
        System.out.println("Kitap: " + book.getTitle());

        // Gecikme gün sayısı ekrana yazdırılır
        System.out.println("Gecikme gün sayısı: " + gecikmeGunSayisi);

        // Hesaplanan ceza miktarı ekrana yazdırılır
        System.out.println("Ceza: " + ceza + " TL");
    }
}
