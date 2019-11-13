package P8.ej3_a;


import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Corredor implements Runnable {

    private int longitud = 0;

    public Corredor(int longitudCarrera){
        this.longitud = longitudCarrera;
    }

    @Override
    public void run() {
        Random r = new Random();
        int rand = r.nextInt(20)+50;  //paso de la mitad de la carrera

        String threadName = Thread.currentThread().getName();
        for (int i=0; i<longitud; i++) {
            try {
                System.out.println(threadName + " recorrio " + i + " mts");
                TimeUnit.MILLISECONDS.sleep(10);
                if (i == rand ){
                    throw new ThreadDeath();
                }
            } catch (InterruptedException e) {
                System.out.println("A mi no se me interrumpe");
            }
        }
        System.out.println( threadName + " termino ");
    }


}
