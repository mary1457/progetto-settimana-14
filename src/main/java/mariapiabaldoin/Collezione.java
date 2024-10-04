package mariapiabaldoin;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import static java.util.Comparator.comparingDouble;

public class Collezione {

    List<Gioco> giochi = new ArrayList<>();

    public void aggiungiGioco(Gioco gioco) throws Exception {
        if (giochi.stream().anyMatch(gio -> gio.getIdGioco() == gioco.getIdGioco())) {
            throw new Exception("L'ID è gia presente: il gioco non può essere inserito");
        } else {
            giochi.add(gioco);
            System.out.println("Il gioco è stato inserito");
        }
    }

    public void ricercaId(int idGioco) {
        Gioco giocoId = giochi.stream()
                .filter(gio -> gio.getIdGioco() == idGioco).findFirst().orElse(null);
        if (giocoId != null) {
            System.out.println(giocoId.toString());
        } else {
            System.out.println("L'ID non corrisponde: nessun gioco trovato");
        }

    }

    public void ricercaPrezzo(double prezzo) {
        List<Gioco> listaPrezzo = giochi.stream()
                .filter(gio -> gio.getPrezzo() < prezzo)
                .toList();
        if (listaPrezzo.isEmpty()) {
            System.out.println("Non sono presenti giochi con prezzo inferiore a quello inserito");
        } else {
            System.out.println(listaPrezzo.toString());
        }

    }

    public void ricercaGiocatori(int numeroGiocatori) {
        List<Gioco> listaGiocatori = giochi.stream().filter(gio -> gio instanceof GiocoDaTavolo).filter(gio -> ((GiocoDaTavolo) gio).getNumeroGiocatori() == numeroGiocatori)
                .toList();
        if (listaGiocatori.isEmpty()) {
            System.out.println("Non sono presenti giochi con numero di giocatori uguale a quello inserito");
        } else {
            System.out.println(listaGiocatori.toString());
        }

    }

    public void rimuoviGioco(Gioco gioco) throws Exception {
        boolean rimozione = giochi.removeIf(gio -> gio.getIdGioco() == gioco.getIdGioco());
        if (rimozione) {
            System.out.println("Il gioco è stato rimosso");
        } else {
            System.out.println("L'ID non corrisponde: nessun gioco rimosso");
        }
    }

    public void aggiornaGioco(int idGioco, String titolo, int annoPubblicazione, double prezzo) {
        Gioco giocoAggiornato = giochi.stream()
                .filter(gio -> gio.getIdGioco() == idGioco).findFirst().orElse(null);
        if (giocoAggiornato != null) {
            giocoAggiornato.setTitolo(titolo);
            giocoAggiornato.setAnnoPubblicazione(annoPubblicazione);
            giocoAggiornato.setPrezzo(prezzo);
            System.out.println(giocoAggiornato.toString());
        } else {
            System.out.println("L'ID non corrisponde: nessun gioco aggiornato");
        }
    }

    public void statisticheCollezione() {
        int numeroVideo = giochi.stream()
                .filter(gio -> gio instanceof Videogioco)
                .toList().size();
        System.out.println("Il numero totale di videogiochi è " + numeroVideo);
        int numeroTavolo = giochi.stream()
                .filter(gio -> gio instanceof GiocoDaTavolo)
                .toList().size();
        System.out.println("Il numero totale di giochi da tavolo è " + numeroTavolo);

        Gioco prezzoMaggiore = giochi.stream().sorted(comparingDouble(Gioco::getPrezzo).reversed()).toList().get(0);
        System.out.println("Il gioco con il prezzo più alto è " + prezzoMaggiore.toString());

        OptionalDouble mediaPrezzi = giochi.stream().mapToDouble(gio -> gio.getPrezzo()).average();
        if (mediaPrezzi.isPresent()) System.out.println("La media dei prezzi è: " + mediaPrezzi.getAsDouble());
        else System.out.println("Non è possibile calcolare la media perché la lista è vuota");

    }
}
