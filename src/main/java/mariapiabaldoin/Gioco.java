package mariapiabaldoin;

public abstract class Gioco {
    private int idGioco;
    private String titolo;
    private int annoPubblicazione;
    private double prezzo;


    public Gioco(int idGioco, String titolo, int annoPubblicazione, double prezzo) {
        this.idGioco = idGioco;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        setPrezzo(prezzo);
    }

    public int getIdGioco() {
        return idGioco;
    }

    public void setIdGioco(int idGioco) {
        this.idGioco = idGioco;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        if (prezzo > 0) {
            this.prezzo = prezzo;
        } else {
            throw new IllegalArgumentException("Il prezzo deve essere maggiore di zero");
        }
    }

    @Override
    public String toString() {
        return "Gioco " +
                "idGioco=" + idGioco +
                ", titolo=" + titolo +
                ", anno pubblicazione=" + annoPubblicazione +
                ", prezzo=" + prezzo;
    }
}
