import java.io.Serializable;

public class Libro extends ElementoCatalogo  implements Serializable {
    private String autore;
    private String genere;

//    private static final long serialVersionUID = 1L;

    public Libro(String isbn, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    //costruttore senza parametri
//    public Libro() {
//        super("", "", 0, 0);
//        this.autore = "";
//        this.genere = "";
//    }



    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
    @Override
    public String toString() {
        return "Libro{" + "autore=" + autore + ", genere=" + genere + '}';
    }
}
