package Magazines;
import pl.majkut.press.Payment;
import pl.majkut.press.Print;
//package pl.majkut.press;

public class Magazine extends Payment implements Print {
    // klasa Magazine - klasa magazynu

    String nameOfMagazine;
    String publishingHouseMagazine;  // wydawnictwo magazynu
    long countMagazine;  // ilość wydanego magazynu
    float priceBulk = 30; // cena hurtowa
    double price = 55; // cena detaliczna

    public Magazine(String nameOfMagazine, String publishingHouseMagazine, long countMagazine) {  // konstruktor
        this.nameOfMagazine = nameOfMagazine;
        this.publishingHouseMagazine = publishingHouseMagazine;
        this.countMagazine = countMagazine;
    }

    // stworzenie metod, które umożliwiają pobranie nazw poszczególnych pól klasy
    public String getNameOfMagazine() {
        return nameOfMagazine;
    }

    public String getPublishingHouseMagazine() {
        return publishingHouseMagazine;
    }

    public long getCountMagazine() {
        return countMagazine;
    }

    // stworzenie metod, które umożliwiają ustawienie nazw klasy
    public void setNameOfMagazine(String nameOfMagazine) {
        this.nameOfMagazine = nameOfMagazine;
    }

    public void setPublishingHouseMagazine() {
        this.publishingHouseMagazine = publishingHouseMagazine;
    }

    public void setCountMagazine() {
        this.countMagazine = countMagazine;
    }

    public double calculateOfPayment() {  // oblicza zapłatę
        if(countMagazine >= 100){
            System.out.println("Znizka 10%. Do zaplaty: " + 0.1*(countMagazine*priceBulk));
            return 0.1*(countMagazine*priceBulk);
        }
        else {
            System.out.println("Cena detaliczna. Do zaplaty: " + countMagazine*price);
            return countMagazine*price;
        }
    }

    @Override
    public void print() {
        System.out.println("\t Magazyn:");
        System.out.println("\n Nazwa magazynu: " + nameOfMagazine + "\n Wydawnictwo: " + publishingHouseMagazine + "\n Ilość kopii: " + countMagazine + "\n Do zapłaty: " + calculateOfPayment());
        System.out.println("\n");
    }
}
