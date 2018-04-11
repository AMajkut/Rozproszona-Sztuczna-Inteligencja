package Magazines;
//package pl.majkut.press;

public class Advertisement extends Magazine{
    // klasa Advertisement - reklama nowego nakładu magazynu

    String typeOfAdvertisment;
    String format;

    public Advertisement (String nameOfMagazine, String publishingHouseMagazine, long countMagazine, String typeOfAdvertisment, String format) {    // konstruktor
        super(nameOfMagazine, publishingHouseMagazine, countMagazine);
        this.typeOfAdvertisment = typeOfAdvertisment;
        this.format = format;
    }

    public String getTypeOfAdvertisment() {
        return typeOfAdvertisment;
    }

    public String getFormat() {
        return format;
    }

    public void setTypeOfAdvertisment(String typeOfAdvertisment) {
        this.typeOfAdvertisment = typeOfAdvertisment;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void print() {
        System.out.println("\t Reklama:");
        System.out.println("\n Nazwa magazynu: " + nameOfMagazine + "\n Wydawnictwo: " + publishingHouseMagazine + "\n Ilość: " + countMagazine + "\n Nazwa reklamy: " + typeOfAdvertisment + "\n Format reklamy: " + format);
        System.out.println("\n");
    }
}