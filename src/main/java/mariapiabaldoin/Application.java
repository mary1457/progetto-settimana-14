package mariapiabaldoin;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Collezione giochi = new Collezione();
        Scanner scanner = new Scanner(System.in);
        Gioco gioco1 = new Videogioco(1, "Super Mario", 2000, 15.00, "Wii", 5, Genere.AVVENTURA);
        Gioco gioco2 = new Videogioco(2, "Just Dance", 2004, 10.00, "Wii", 10, Genere.AZIONE);
        Gioco gioco3 = new GiocoDaTavolo(3, "Monopoli", 2006, 30.00, 6, 90);
        Gioco gioco4 = new GiocoDaTavolo(4, "Uno", 2010, 25.00, 10, 30);

        try {
            giochi.aggiungiGioco(gioco1);
            giochi.aggiungiGioco(gioco2);
            giochi.aggiungiGioco(gioco3);
            giochi.aggiungiGioco(gioco4);


            while (true) {

                System.out.println("Scegli un azione: aggiungi gioco(1), ricerca tramite ID(2), ricerca tramite prezzo(3), ricerca tramite giocatori(4), rimuovi gioco(5), aggiorna gioco(6), statistiche(7), esci(0)");
                int scelta = scanner.nextInt();
                if (scelta == 0) {
                    System.out.println("Esci");
                    break;
                }
                switch (scelta) {
                    case 1:

                        System.out.println("Che cosa vuoi creare? Un videogioco(1) o un gioco da tavolo(2)?");
                        int sceltaGioco = scanner.nextInt();
                        System.out.println("Inserisci id");
                        int id = scanner.nextInt();
                        System.out.println("Inserisci titolo");
                        String titolo = scanner.next();
                        System.out.println("Inserisci anno");
                        int anno = scanner.nextInt();
                        System.out.println("Inserisci prezzo");
                        double prezzo = scanner.nextDouble();
                        if (sceltaGioco == 1) {
                            System.out.println("Inserisci piattaforma");
                            String piattaforma = scanner.next();
                            System.out.println("Inserisci durata");
                            int durata = scanner.nextInt();
                            System.out.println("Inserisci genere");
                            String genere = scanner.next().toUpperCase();
                            Genere genere1 = Genere.valueOf(genere);
                            Videogioco videogioco = new Videogioco(id, titolo, anno, prezzo, piattaforma, durata, genere1);
                            giochi.aggiungiGioco(videogioco);
                        } else {
                            System.out.println("Inserisci numero di giocatori");
                            int numero = scanner.nextInt();
                            System.out.println("Inserisci durata");
                            int durata = scanner.nextInt();
                            GiocoDaTavolo giocoDaTavolo = new GiocoDaTavolo(id, titolo, anno, prezzo, numero, durata);
                            giochi.aggiungiGioco(giocoDaTavolo);
                        }

                        break;
                    case 2:
                        System.out.println("Inserisci ID per la ricerca");
                        int idRicerca = scanner.nextInt();
                        giochi.ricercaId(idRicerca);
                        break;
                    case 3:
                        System.out.println("Inserisci prezzo per la ricerca");
                        double prezzoRicerca = scanner.nextDouble();
                        giochi.ricercaPrezzo(prezzoRicerca);
                        break;
                    case 4:
                        System.out.println("Inserisci il numero di giocatori per la ricerca");
                        int giocatoriRicerca = scanner.nextInt();
                        giochi.ricercaGiocatori(giocatoriRicerca);
                        break;
                    case 5:
                        System.out.println("Inserisci ID per la rimozione");
                        int idRimozione = scanner.nextInt();
                        giochi.rimuoviGioco(idRimozione);
                        break;
                    case 6:
                        System.out.println("Inserisci id per la modifica");
                        int idModifica = scanner.nextInt();
                        System.out.println("Inserisci titolo");
                        String titoloModifica = scanner.next();
                        System.out.println("Inserisci anno");
                        int annoModifica = scanner.nextInt();
                        System.out.println("Inserisci prezzo");
                        double prezzoModifica = scanner.nextDouble();
                        giochi.aggiornaGioco(idModifica, titoloModifica, annoModifica, prezzoModifica);
                        break;
                    case 7:
                        System.out.println("Stampa statistiche");
                        giochi.statisticheCollezione();
                        break;
                    default:
                        System.out.println("Numero non compreso tra 1 e 7");
                        break;
                }
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            scanner.close();
        }
    }
}
