package mariapiabaldoin;

public class GiocoDaTavolo extends Gioco {
    private int numeroGiocatori;
    private int durata;


    public GiocoDaTavolo(int idGioco, String titolo, int annoPubblicazione, double prezzo, int numeroGiocatori, int durata) {
        super(idGioco, titolo, annoPubblicazione, prezzo);
        setNumeroGiocatori(numeroGiocatori);
        this.durata = durata;


    }

    public int getNumeroGiocatori() {
        return numeroGiocatori;
    }

    public void setNumeroGiocatori(int numeroGiocatori) {
        if (numeroGiocatori >= 2 && numeroGiocatori <= 10) {
            this.numeroGiocatori = numeroGiocatori;
        } else {
            throw new IllegalArgumentException("Il numero di giocatori deve essere compreso tra 2 e 10");
        }

    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    @Override
    public String toString() {
        return "Gioco " +
                "idGioco=" + getIdGioco() +
                ", titolo=" + getTitolo() +
                ", anno pubblicazione=" + getAnnoPubblicazione() +
                ", prezzo=" + getPrezzo() +
                ", numero di giocatori=" + numeroGiocatori +
                ", durata=" + durata;
    }

}

