import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Medico extends Thread {

    Random random = new Random();
    private BlockingQueue<Esame> codaEsami;
    public Medico(String name, BlockingQueue<Esame> codaEsami) {
            super(name);
            this.codaEsami = codaEsami;
    }

    public void run() {
        while(true) {
            if (codaEsami.isEmpty()) {
                System.out.println("Inizio Gioco carte");
                int randomNum = random.nextInt(1000);
                long sleepTime = (4* randomNum + 1000);
                System.out.println("Inizio Gioco carte per " + sleepTime);
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
                    try {
                        Thread.sleep( randomNum + 1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}

