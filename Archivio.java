import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

public class Archivio implements Serializable {
//    private static final long serialVersionUID = 2L;

    public String toString() {
        return "Archivio{" + "elementi=" + elementi + '}';
    }
    private List<ElementoCatalogo> elementi;

    public Archivio() {
        this.elementi = new ArrayList<>();
    }

    public void aggiungiElemento(ElementoCatalogo elemento) {
        elementi.add(elemento);
    }

    public void rimuoviElementoPerISBN(String isbn) {
        elementi.removeIf(e -> e.getIsbn().equals(isbn));
    }

    public ElementoCatalogo cercaPerISBN(String isbn) {
        return elementi.stream()
                .filter(e -> e.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

  public List<ElementoCatalogo> cercaPerAnnoPubblicazione(int anno) {
        return elementi.stream()
                .filter(e -> e.getAnnoPubblicazione() == anno)
                .collect(Collectors.toList());
    }

    public List<ElementoCatalogo> cercaPerAutore(String autore) {
        return elementi.stream()
                .filter(e -> e instanceof Libro && ((Libro) e).getAutore().equals(autore))
                .collect(Collectors.toList());
    }

    public List<ElementoCatalogo> cercaPerGenere(String genere) {
        return elementi.stream()
                .filter(e -> e instanceof Libro && ((Libro) e).getGenere().equals(genere))
                .collect(Collectors.toList());
    }

    public void salvaSuDisco(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.out.println(this);
            e.printStackTrace();
        }
    }

    public static Archivio caricaDaDisco(String filename) {
        Archivio archivio = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
           archivio= (Archivio) ois.readObject();
           ois.close();
              return archivio;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    public List<ElementoCatalogo> getElementi() {
        return this.elementi;
    }





    /////////////////////////////////////////METODI AGGIUNTIVI PER PROVARE ////////////////////////////////////////////
    public Map<Integer, List<ElementoCatalogo>> raggruppaPerAnnoPubblicazione() {
        return elementi.stream()
                .collect(groupingBy(ElementoCatalogo::getAnnoPubblicazione));
    }

    public Map<String, Long> contaLibriPerAutore() {
        return elementi.stream()
                .filter(e -> e instanceof Libro)
                .map(e -> (Libro) e)
                .collect(groupingBy(Libro::getAutore, counting()));
    }

    public Set<ElementoCatalogo> cercaPerGenereUnico(String genere) {
        return elementi.stream()
                .filter(e -> e instanceof Libro && ((Libro) e).getGenere().equals(genere))
                .collect(toSet());
    }


    // metodo stampaCercaPerGenereUnico
    public void stampaPerGenereUnico(String genere) {
        Set<ElementoCatalogo> trovatiPerGenere = cercaPerGenereUnico("Romanzo fantasy");
        System.out.println("Trovati per Genere: " + trovatiPerGenere.size() + "  Il genere:  "+ trovatiPerGenere);
    }

    //metodo stampaPerAnnoPubblicazione
    public void stampaPerAnnoPubblicazione() {
        Map<Integer, List<ElementoCatalogo>> trovatiPerAnno = raggruppaPerAnnoPubblicazione();
        System.out.println("Trovati per Anno di Pubblicazione: " + trovatiPerAnno.size()+ "  L'anno:  "+ trovatiPerAnno);
    }

    //metodo stampaPerAutore

    public void stampaPerAutore() {
        Map<String, Long> trovatiPerAutore = contaLibriPerAutore();
        System.out.println("Trovati per Autore: " + trovatiPerAutore.size() + "  L'autore:  "+ trovatiPerAutore);
    }




}
