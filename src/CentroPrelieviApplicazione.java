import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
public class CentroPrelieviApplicazione {
    public static void main(String[] args) {

        Segretaria segretaria = new Segretaria();
        BlockingQueue<Esame> queue = new ArrayBlockingQueue<>(6);
        Paziente[] pazienti = new Paziente[4];
        // 4 pazienti
        for(int i = 0; i < 4; i++) {
            Paziente paziente = new Paziente("Paziente_" + i, queue);
            segretaria.registraPerEsito(paziente);
            pazienti[i] = paziente;
            pazienti[i].start();
        }

        // 1 medico
        Medico medico = new Medico("Medico", queue, segretaria);
        medico.start();
    }
}