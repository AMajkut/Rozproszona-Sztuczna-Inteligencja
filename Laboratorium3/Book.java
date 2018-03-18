public class Book extends Payment implements Print {
    // klasa Book - klasa książek

    String author;  // autor książki
    String title;  // tytuł książki
    String publishingHouse;  // wydawnictwo ksiązki
    long count;  // ilość książki
    float priceBulk = 50; // cena hurtowa
    double price = 80; // cena detaliczna

    Book (String author, String title, String publishingHouse, long count) {  // konstruktor
        this.author = author;
        this.title = title;
        this.publishingHouse = publishingHouse;
        this.count = count;
    }

    public double calculateOfPayment() {  // oblicza zapłatę
        if(count >= 1000){
            System.out.println("Znizka 30%. Do zaplaty: " + 0.3*(count*priceBulk));
            return 0.3*(count*priceBulk);
        }
        else {
            System.out.println("Cena detaliczna. Do zaplaty: " + count*price);
            return count*price;
        }
    }

    public void print()
    {
        System.out.println("\t Książka:");
        System.out.println("\n Autor: " + author + "\n Tytuł: " + "'" + title + "'"  + "\n Wydawnictwo: " + publishingHouse + "\n Ilość kopii: " + count + "\n Do zapłaty: " + calculateOfPayment());
        System.out.println("\n");
    }
}
