package pl.majkut.press;
import Books.Book;
//import Books.Poster;
//import Magazines.Advertisement;
import Magazines.Magazine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.Throwable; // wyjatki
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Press {

    static Scanner scanner = new Scanner(System.in); // umożliwia wpisywanie danych


    public static void zmiennoprzecinkowe() {
        /* odczyt z pliku, który zawiera liczby zmiennoprzecinkowe */
        System.out.print("Odczyt z pliku zawierający liczby przecinkowe: ");
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\__Rozproszona Sztuczna Inteligencja\\LABORATORIA\\lab_5\\ZmiennoPrzecinkowe.txt");

            // Odczytywanie jednego bajtu z pliku
            int b = fileInputStream.read();

            while(b != -1) {            // dopóki jest bajt
                // Rzutowanie na typ znakowy
                System.out.print((char) b);
                b = fileInputStream.read();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n");
    }

    public static double addOrder(int count, double price, float priceBulk) throws InputMismatchException{

        System.out.println("Co chcesz zamówić?" + "\n Książkę" + "\n Magazyn");
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Wybrano książke.");
                System.out.println("Autor: " + scanner.nextInt());
                System.out.println("Tytuł: " + scanner.nextInt());
                System.out.println("Wydawnictwo: " + scanner.nextInt());

            case 2:
                System.out.println("Wybrano magazyn.");
                System.out.println("Nazwa magazynu: " + scanner.nextInt());
                System.out.println("Wydawnictwo: " + scanner.nextInt());
        }

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

        System.out.println("Podaj ilość kopii:");   // wprowadzenie danych z klawiatury
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


    public static void main(String[] args) throws FileNotFoundException{

        File plik = new File("Press.txt");  //

        float priceBulk = 50; // cena hurtowa
        double price = 80; // cena detaliczna
        int count = 0; // ilosc kopii
        char[] finish = new char[]{'P', 'r', 'o', 'c', 'e', 's', ' ', 'z', 'a', 'k', 'o', 'n', 'c', 'z', 'o', 'n', 'y', '.'};
        int[][] index = new int[100][1000]; // indeks kopii [100] - która drukarka; [1000] - które zamówienie z danej drukarki
        boolean order = false;
        boolean exit = false;

        while (exit != true) {
            try {

                System.out.println("\t\n Wyświetlenie liczb zmiennoprzecinkowych: ");
                zmiennoprzecinkowe();
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
                        /* ZAPIS DO PLIKU */
                        PrintWriter write = new PrintWriter("Book.txt");
                        Book book = new Book("Stephen King", "Smentarz dla zwierząt", "Prószyński i Sp.", 1000);
                        book.print();
//                        write.println("Autor: Stephen King" + "\t Tytuł: Smentarz dla zwierząt" + "\t Wydawnictwo: Prószyński i Sp." + "\t Ilość: " + 1000);
                        write.println("Autor: Stephen King");
                        write.println("Tytuł: Smentarz dla zwierząt");
                        write.println("Wydawnictwo: Prószyński i Sp.");
                        write.println("Ilość: " + 1000);
                        write.close();

                        /* ZAPIS DO PLIKU */
                        Magazine magazine = new Magazine("Świat Wiedzy", "Bauer", 100);
                        magazine.print();
                        PrintWriter write2 = new PrintWriter("Magazine.txt");
//                        write2.println("Nazwa magazynu: Świat Wiedzy" + "\t Wydawnictwo: Bauer" + "\t Ilość: " + 100);
                        write2.println("Nazwa magazynu: Świat Wiedzy");
                        write2.println("Wydawnictwo: Bauer");
                        write2.println("Ilość: " + 100);
                        write2.close();

                        /* SERIALIZACJA */
                        Books.Poster poster = new Books.Poster("Stephen King", "Smentarz dla zwierząt", "Prószyński i Sp.", 1000, "A3");
                        poster.getPosterFormat();   // sprawdzanie rozszerzenia klasy Poster przez metody klasy Book
                        poster.print();

                        // zapis do pliku
                        PrintWriter serialWrite = new PrintWriter("Poster(serial).txt");
                        serialWrite.println(poster.getAuthor() + " " + poster.getTitle() + " " + poster.getPublishingHouse() + " " + poster.getCount() + " " + poster.getPosterFormat());
                        serialWrite.close();
                        System.out.println("Sprawdzenie roszczerzenia klas dla klasy 'Poster': \n użycie dziedziczonej metody 'getTitle' z klasy 'Book': \n" + poster.getTitle() + "\n");

                        // odczyt z pliku zapisany w wyniku serializacji
                        File file = new File("Poster(serial).txt");
                        Scanner po = new Scanner(file);

                        String serialRead = po.nextLine();
                        System.out.println(serialRead + "\n");

                        /* SERIALIZACJA */
                        // System.out.println("Reklama nowego wydania gazety Świat Wiedzy");
                        Magazines.Advertisement advertisement = new Magazines.Advertisement("Reklama nowego wydania gazety Świat Wiedzy", "Bauer", 100, "Reklama nowego wydania Swiata Wiedzy! Kup już dziś!", "A5");
                        advertisement.getClass();
                        advertisement.print();

                        // zapis do pliku
                        PrintWriter serialWrite2 = new PrintWriter("Advertisment(serial).txt");
                        serialWrite2.println(advertisement.getNameOfMagazine() + " " + advertisement.getPublishingHouseMagazine() + " " + advertisement.getCountMagazine() + " " + advertisement.getTypeOfAdvertisment() + " " + advertisement.getFormat());
                        serialWrite2.close();
                        System.out.println("Sprawdzenie roszczerzenia klas dla klasy 'Advertisment': \n użycie dziedziczonej metody 'getTypeOfAdverisment' z klasy 'Magazine': \n" + advertisement.getTypeOfAdvertisment() + "\n");

                        // odczyt z pliku zapisany w wyniku serializacji
                        File file2 = new File("Adverisment(serial).txt");
                        Scanner ad = new Scanner(file2);

                        String serialRead2 = ad.nextLine();
                        System.out.println(serialRead2 + "\n");
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

//    public void save() throws FileNotFoundException{
//        PrintWriter zapis = new PrintWriter("Press.txt");
//        zapis.println("pressss");
//        zapis.close();
//    }
}