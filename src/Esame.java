public class Esame {
    public final String name;
    public final int numEsame;

    public Esame(String name, int numEsame) {
        this.name = name;
        this.numEsame = numEsame;
    }

    @Override
    public String toString() {
        return "Esame{" +
                "name='" + name + '\'' +
                ", numEsame=" + numEsame +
                '}';
    }
}
