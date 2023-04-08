import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Medico extends Thread {
    Random random = new Random();
    private BlockingQueue<Esame> codaEsami;
    private Segretaria segretaria;

    public Medico(String name, BlockingQueue<Esame> codaEsami, Segretaria segretaria) {
            super(name);
            this.codaEsami = codaEsami;
            this.segretaria = segretaria;
    }

    public void run() {
        while(true) {
            if (codaEsami.isEmpty()) {
                int randomNum = random.nextInt(1000);
                long sleepTime = (4* randomNum + 1000);
                System.out.println("Inizio Gioco carte per: " + sleepTime + " ms.");
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            } else {
                Esame esame = null;
                try {
                    esame = codaEsami.take();
                    System.out.println("Sto esaminando " + esame + "\n");
                    int randomNum = random.nextInt(1000);
                    Thread.sleep( randomNum + 1000);
                    EsitoEsame esitoEsame = new EsitoEsame(esame, EsitoEsame.Esito.TUTTO_OK);
                    segretaria.comunicaPaziente(esame.namePaziente, esitoEsame);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}

