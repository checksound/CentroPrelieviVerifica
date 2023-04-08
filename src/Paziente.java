import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Paziente extends Thread {
        private boolean hasEsito = false;
        private EsitoEsame esitoEsame;
        private Random random = new Random();
        private BlockingQueue<Esame> queue;
        public Paziente(String name, BlockingQueue<Esame> queue) {
            super(name);
            this.queue = queue;
        }

        public void run() {
            int numEsame = 1;
            while(true) {

                Esame esame = new Esame(Thread.currentThread().getName(), numEsame);
                numEsame++;
                try {
                    queue.put(esame);
                    System.out.println(Thread.currentThread().getName() + " - RICHIESTA ESAME: " + esame);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                EsitoEsame esitoEsame = waitRispostaDottore();

                System.out.println("Arrivate risposta esame: " + esitoEsame);

                int randomNum = random.nextInt(1000);

                try {
                    Thread.sleep(4 * randomNum + 5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }

        private synchronized EsitoEsame waitRispostaDottore() {
            while(!hasEsito) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            hasEsito = false;
            return esitoEsame;
        }

        public synchronized void  setEsito(EsitoEsame esitoEsame) {
            this.hasEsito = true;
            this.esitoEsame = esitoEsame;
    }

    public String toString() {
            return "Paziente[nome=" + getName() + "]";
    }

}
