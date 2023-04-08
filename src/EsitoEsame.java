public class EsitoEsame {

    public enum Esito {
        TUTTO_OK,
        ALTRO_ESAME
    }

    public final Esame esame;
    public final Esito esito;
    public EsitoEsame(Esame esame, Esito esito) {
        this.esame = esame;
        this.esito = esito;
    }

    @Override
    public String toString() {
        return "EsitoEsame{" +
                "esame=" + esame +
                ", esito=" + esito +
                '}';
    }
}


