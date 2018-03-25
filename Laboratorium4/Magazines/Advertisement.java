package Magazines;
//package pl.majkut.press;

public class Advertisement {
    // klasa Advertisement - reklama nowego nakładu magazynu

    String typeOfAdvertisment;
    String format;

    public Advertisement (String typeOfAdvertisment, String format) {  // konstruktor
        this.typeOfAdvertisment = typeOfAdvertisment;
        this.format = format;
    }

    public void print() {
        System.out.println("\t Reklama:");
        System.out.println("\n Nazwa reklamy: " + typeOfAdvertisment + "\n Format reklamy: " + format);
        System.out.println("\n");
    }
}
