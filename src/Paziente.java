import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Paziente extends Thread {

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
                    System.out.println(Thread.currentThread().getName() + " - RICHIESTA ESAME: " + esame );
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                int randomNum = random.nextInt(1000);

                try {
                    Thread.sleep(4 * randomNum + 5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
}
