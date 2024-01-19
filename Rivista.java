import java.io.Serializable;

public class Rivista extends ElementoCatalogo implements Serializable {
//    private static final long serialVersionUID = 3L;
    public enum Periodicita { SETTIMANALE, MENSILE, SEMESTRALE }
    private Periodicita periodicita;

    // Costruttore completo
    public Rivista(String isbn, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    // Metodo getter per periodicita
    public Periodicita getPeriodicita() {
        return periodicita;
    }

    // Metodo setter per periodicita
    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    // Metodi getter e setter per gli altri attributi ereditati da ElementoCatalogo
    // (isbn, titolo, annoPubblicazione, numeroPagine)

    @Override
    public String toString() {
        return "Rivista{" +
                "isbn='" + isbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                ", periodicita=" + periodicita +
                '}';
    }
}
