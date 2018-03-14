import java.awt.*;
import java.awt.desktop.SystemSleepEvent;
import java.util.Scanner;

public class Press {

    static Scanner scanner = new Scanner(System.in); // umożliwia wpisywanie danych

    public static double addOrder( int count, double price, float priceBulk){

        System.out.println("Podaj ilosc kopii:");
        count = scanner.nextInt();

        System.out.println("Podaj format kopii: \n 1. A4 \n 2. A3 \n 3. B4 \n 4. B3");
        switch (scanner.nextInt()){
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
                System.out.println("Podaj wartosc: 1, 2, 3 lub 4.");
                break;
        }

        if(count >= 1000){
            System.out.println("Znizka 30%. Do zaplaty: " + 0.3*(count*priceBulk));
            return 0.3*(count*priceBulk);
        }
        else {
            System.out.println("Cena detaliczna. Do zaplaty:" + count*price);
             return count*price;
        }
    }

    public static void statusOrder(boolean order){
        if (order == false){
            System.out.println("Zamowienie w trakcie realizacji.");
        }
        else {
            System.out.println("Zamowienie gotowe do odbioru.");
        }
    }

    public static void main(String[] args) {

        float priceBulk = 50; // cena hurtowa
        double price = 80; // cena detaliczna
        boolean order = false;
        int count = 0; // ilosc kopii
        short format; // formant kopii (A4, A3, B4, B3)
        char [] finish = new char [] {'P','r','o','c','e','s',' ','z','a','k','o','n','c','z','o','n','y','.'};
        int [][] index = new int[100][1000]; // indeks kopii [100] - która drukarka; [1000] - które zamówienie z danej drukarki
        boolean exit = false;

        while(exit != true){

            System.out.println(" \n WITAMY W DRUKARNII!");
            System.out.println("Wybierz co chcesz zrobic.");
            System.out.println("1. Dodaj zamowienie.");
            System.out.println("2. Sprawdz status zamowienia.");
            System.out.println("3. Wyjscie.");

            switch(scanner.nextInt()){
                case 1:
                    addOrder(count, price, priceBulk);
                    System.out.println("Dodales zamowienie.");
                    order = true;
                    break;

                case 2:
                    statusOrder(order);
                    break;

                case 3:
                    exit = true;
                    System.out.println(finish);
                    System.out.println("Do widzenia!");
                    break;

                default:
                    System.out.println("Podaj wartosc: 1, 2 lub 3.");
                    break;

            }
        }

    }
}
