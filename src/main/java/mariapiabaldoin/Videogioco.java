package mariapiabaldoin;

public class Videogioco extends Gioco {
    private String piattaforma;
    private int durata;
    private Genere genere;

    public Videogioco(int idGioco, String titolo, int annoPubblicazione, double prezzo, String piattaforma, int durata, Genere genere) {
        super(idGioco, titolo, annoPubblicazione, prezzo);
        this.piattaforma = piattaforma;
        this.durata = durata;
        this.genere = genere;


    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Gioco " +
                "idGioco=" + getIdGioco() +
                ", titolo=" + getTitolo() +
                ", anno pubblicazione=" + getAnnoPubblicazione() +
                ", prezzo=" + getPrezzo() +
                ", piattaforma=" + piattaforma +
                ", durata=" + durata +
                ", genere=" + genere;
    }

}

