public class Poster extends Book {
    // klasa Poster - plakat zachęcający do zakupu nowo wydanej książki; dziedziczy po magazynie

    String posterFormat;

    public Poster(String author, String title, String publishingHouse, long count, String posterFormat) { // konstruktor
        super(author, title, publishingHouse, count);
        this.posterFormat = posterFormat;
    }

    public String getPosterFormat() {
        return posterFormat;
    }

    public String setPosterFormat() {
        return posterFormat;
    }

    public void print()
    {
        System.out.println("\t Plakat książki:");
        System.out.println("\n Autora " + author + " o tytule " + "'" + title + "'" + " wydawnictwa " + publishingHouse + "\n Format plakatu: " + posterFormat);
        System.out.println("\n");
    }
}
