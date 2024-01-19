import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class TestCatalogo {

    public static void main(String[] args) {
        // Creazione del catalogo
       Archivio catalogo = new Archivio();

        // Aggiunta di libri e riviste
        Libro libro1 = new Libro("978-3-16-148410-0", "Il deserto dei tartari", 2020, 300, "Dino Buzzati", "Fantascientifico");
        Libro libro2 = new Libro("978-3-16-148410-1", "Cent'anni di solitudine", 2021, 250, "Gabriel Garcia Marquez", "Realismo magico");
        Libro libro3 = new Libro("978-3-16-148410-2", "Il nome della rosa", 2021, 250, "Umberto Eco", "Romanzo storico giallo");
        Libro libro4 = new Libro("978-3-16-148410-3", "Il signore degli anelli", 2021, 250, "J.R.R. Tolkien", "Saga");
        Rivista rivista1 = new Rivista("978-3-16-148410-2", "Fovus", 2022, 50, Rivista.Periodicita.MENSILE);
        Rivista rivista2 = new Rivista("978-3-16-148410-3", "Portman", 2022, 50, Rivista.Periodicita.MENSILE);
        Rivista rivista3 = new Rivista("978-3-16-148410-4", "GQ", 2022, 50, Rivista.Periodicita.MENSILE);
        Rivista rivista4 = new Rivista("978-3-16-148410-5", "Vanity Fair", 2022, 50, Rivista.Periodicita.MENSILE);
        Libro libro5 = new Libro("978-3-16-148410-0", "Un amore", 2020, 300, "Dino Buzzati", "Narrativa");
        Libro libro6 = new Libro("978-3-16-148410-1", "L'amore ai tempi del colera", 2021, 250, "Gabriel Garcia Marquez", "Romanzo rosa");
        Libro libro7 = new Libro("978-3-16-148410-2", "Il pendolo di Foucault", 2021, 250, "Umberto Eco", "Romanzo fiction speculativa ");
        Libro  libro8 = new Libro("978-3-16-148410-3", "Lo Hobbit", 2021, 250, "J.R.R. Tolkien", "Romanzo fantasy");

        catalogo.aggiungiElemento(libro1);
        catalogo.aggiungiElemento(libro2);
        catalogo.aggiungiElemento(rivista1);
        catalogo.aggiungiElemento(rivista2);
        catalogo.aggiungiElemento(rivista3);
        catalogo.aggiungiElemento(rivista4);
        catalogo.aggiungiElemento(libro3);
        catalogo.aggiungiElemento(libro4);
        catalogo.aggiungiElemento(libro5);
        catalogo.aggiungiElemento(libro6);
        catalogo.aggiungiElemento(libro7);
        catalogo.aggiungiElemento(libro8);




        // Ricerca per ISBN
        ElementoCatalogo trovato = catalogo.cercaPerISBN("978-3-16-148410-0");
        System.out.println("Trovato per ISBN: " + trovato.getTitolo());

        // Ricerca per anno di pubblicazione
        List<ElementoCatalogo> trovatiPerAnno = catalogo.cercaPerAnnoPubblicazione(2020);
        System.out.println("Trovati per Anno di Pubblicazione: " + trovatiPerAnno.size()+ "  L'anno:  "+ libro1.getAnnoPubblicazione());

        // Ricerca per autore
        List<ElementoCatalogo> trovatiPerAutore = catalogo.cercaPerAutore("Umberto Eco");
        System.out.println("Trovati per Autore: " + ((List<?>) trovatiPerAutore).size() + "  L'autore:  "+ libro3.getAutore());

        // Ricerca per genere
        List<ElementoCatalogo> trovatiPerGenere = catalogo.cercaPerGenere("Romanzo fantasy");
        System.out.println("Trovati per Genere: " + ((List<?>) trovatiPerGenere).size() + "  Il genere:  "+ libro4.getGenere()+ "  L'autore:  "+ libro4.getAutore()+ " Il titolo:  "+ libro4.getTitolo());

        // Rimozione per ISBN
        catalogo.rimuoviElementoPerISBN("978-3-16-148410-0");
        System.out.println("Rimosso per ISBN: " + libro1.getIsbn() +" titolo: "+ libro1.getTitolo());


        //Stampa catalogo completo
        System.out.println("Catalogo completo: " + catalogo.toString());

        //Stampa catalogo completo il numero di elementi presenti

       System.out.println("Catalogo completo: " + ((List<?>)catalogo.getElementi()).size());







        // Salvataggio su disco
        catalogo.salvaSuDisco("./catalogo.dat");

//         Caricamento dal disco
        Archivio catalogoCaricato = Archivio.caricaDaDisco("./catalogo.dat");
        if (catalogoCaricato != null) {
            System.out.println("Catalogo caricato con successo. Contiene " + catalogoCaricato.getElementi().size() + " elementi.");
        }


        //metodo stampaPerGenereUnico
        catalogo.stampaPerGenereUnico("Romanzo fantasy");

        //metodo stampaPerAnnoPubblicazione
        catalogo.stampaPerAnnoPubblicazione();

        //metodo stampaPerAutore
        catalogo.stampaPerAutore();

        


    }
}

