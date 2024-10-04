package mariapiabaldoin;

public class Application {

    public static void main(String[] args) {

        Collezione giochi = new Collezione();
        Gioco gioco1 = new Videogioco(1, "Super Mario", 2000, 15.00, "Wii", 5, Genere.AVVENTURA);
        Gioco gioco2 = new Videogioco(2, "Just Dance", 2004, 10.00, "Wii", 10, Genere.AZIONE);
        Gioco gioco3 = new GiocoDaTavolo(3, "Monopoli", 2006, 30.00, 6, 90);
        Gioco gioco4 = new GiocoDaTavolo(4, "Uno", 2010, 25.00, 10, 30);

        try {
            giochi.aggiungiGioco(gioco1);
            giochi.aggiungiGioco(gioco2);
            giochi.aggiungiGioco(gioco3);
            giochi.aggiungiGioco(gioco4);

            giochi.ricercaId(1);
            giochi.ricercaId(5);

            giochi.ricercaPrezzo(25.00);
            giochi.ricercaPrezzo(10.00);

            giochi.ricercaGiocatori(6);
            giochi.ricercaGiocatori(4);

            giochi.rimuoviGioco(gioco4);

            giochi.aggiornaGioco(1, "Super Mario", 2000, 17.00);

            giochi.statisticheCollezione();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
