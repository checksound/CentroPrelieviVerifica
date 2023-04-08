public class Esame {
    public final String namePaziente;
    public final int numEsame;

    public Esame(String namePaziente, int numEsame) {
        this.namePaziente = namePaziente;
        this.numEsame = numEsame;
    }

    @Override
    public String toString() {
        return "Esame{" +
                "name='" + namePaziente + '\'' +
                ", numEsame=" + numEsame +
                '}';
    }
}
