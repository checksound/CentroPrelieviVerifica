import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CentroPrelieviApplicazione {
    public static void main(String[] args) {

        BlockingQueue<Esame> queue = new ArrayBlockingQueue<>(6);
        Paziente[] pazienti = new Paziente[4];
        // 4 pazienti
        for(int i = 0; i < 4; i++) {
            pazienti[i] = new Paziente("Paziente_" + i, queue);
            pazienti[i].start();
        }

        // 1 medico
        Medico medico = new Medico("Medico", queue);
        medico.start();
    }
}