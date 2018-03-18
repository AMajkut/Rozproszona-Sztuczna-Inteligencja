import java.awt.*;
import java.awt.desktop.SystemSleepEvent;
import java.util.Scanner;

public class Press {

    static Scanner scanner = new Scanner(System.in); // umożliwia wpisywanie danych

    public static void main(String[] args) {

        System.out.println(" \n WITAMY W DRUKARNII! \n");

        Book book = new Book("Stephen King", "Smentarz dla zwierząt", "Prószyński i Sp.", 1000);
        book.print();

        Magazine magazine = new Magazine("Świat Wiedzy", "Bauer",100);
        magazine.print();

        Poster poster = new Poster("Stephen King", "Smentarz dla zwierząt","Prószyński i Sp.", 1000, "A3");
        poster.print();

       // System.out.println("Reklama nowego wydania gazety Świat Wiedzy");
        Advertisement advertisement = new Advertisement("Reklama nowego wydania gazety Świat Wiedzy","A4");
        advertisement.print();
    }
}

