package pl.majkut.press;
import Books.Book;
//import Books.Poster;
//import Magazines.Advertisement;
import Magazines.Magazine;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.Throwable; // wyjatki

public class Press {

    static Scanner scanner = new Scanner(System.in); // umożliwia wpisywanie danych

    public static double addOrder(int count, double price, float priceBulk) throws InputMismatchException {

        System.out.println("Podaj format kopii: \n 1. A4 \n 2. A3 \n 3. B4 \n 4. B3");
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Wybrano format A4.");
                break;
            case 2:
                System.out.println("Wybrano format A3.");
                break;
            case 3:
                System.out.println("Wybrano format B4.");
                break;
            case 4:
                System.out.println("Wybrano format B3.");
                break;

            default:
                throw new InputMismatchException("Niedozwolony znak. Podaj cyfrę od 1 do 4.");
                //break;
        }

        System.out.println("Podaj ilość kopii:");
        count = scanner.nextInt();
        if (count >= 0) {
            throw new IllegalArgumentException("Podana wartość musi być większa od 0.");
        }
        else if (count >= 1000) {
            System.out.println("Zniżka 30%. Do zapłaty: " + 0.3 * (count * priceBulk));
            return 0.3 * (count * priceBulk);
        } else {
            System.out.println("Cena detaliczna. Do zapłaty:" + count * price);
            return count * price;
            }
    }

        public static void statusOrder ( boolean order){
            if (order == false) {
                System.out.println("Zamówienie w trakcie realizacji.");
            } else {
                System.out.println("Zamówienie gotowe do odbioru.");
            }
        }


    public static void main(String[] args) {

        float priceBulk = 50; // cena hurtowa
        double price = 80; // cena detaliczna
        int count = 0; // ilosc kopii
        char[] finish = new char[]{'P', 'r', 'o', 'c', 'e', 's', ' ', 'z', 'a', 'k', 'o', 'n', 'c', 'z', 'o', 'n', 'y', '.'};
        int[][] index = new int[100][1000]; // indeks kopii [100] - która drukarka; [1000] - które zamówienie z danej drukarki
        boolean order = false;
        boolean exit = false;

        while (exit != true) {
            try {

                System.out.println(" \n WITAMY W DRUKARNII!");
                System.out.println("Wybierz co chcesz zrobić.");
                System.out.println("1. Dodaj zamówienie.");
                System.out.println("2. Sprawdź status zamówienia.");
                System.out.println("3. Najnowsze pozycje w drukrnii.");
                System.out.println("4. Wyjście.");

                switch (scanner.nextInt()) {

                    case 1:
                        addOrder(count, price, priceBulk);
                        System.out.println("Dodałeś zamówienie.");
                        order = true;
                        break;

                    case 2:
                        statusOrder(order);
                        break;

                    case 3:
                        Book book = new Book("Stephen King", "Smentarz dla zwierząt", "Prószyński i Sp.", 1000);
                        book.print();

                        Magazine magazine = new Magazine("Świat Wiedzy", "Bauer", 100);
                        magazine.print();

                        Books.Poster poster = new Books.Poster("Stephen King", "Smentarz dla zwierząt", "Prószyński i Sp.", 1000, "A3");
                        poster.print();

                        // System.out.println("Reklama nowego wydania gazety Świat Wiedzy");
                        Magazines.Advertisement advertisement = new Magazines.Advertisement("Reklama nowego wydania gazety Świat Wiedzy", "A4");
                        advertisement.print();
                        break;

                    case 4:
                        exit = true;
                        System.out.println(finish);
                        System.out.println("Do widzenia!");
                        break;

                    default:
                        throw new IllegalArgumentException("Podaj wartość: 1, 2, 3 lub 4.");

                }
            } catch (InputMismatchException expection) {
                System.out.println("Niedozwolony znak. Podaj cyfrę od 1 do 4.");
            } finally {
                break;
            }
        }
    }
}