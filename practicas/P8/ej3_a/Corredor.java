package ej3_a;


import java.util.concurrent.TimeUnit;

public class Corredor implements Runnable {

    private int longitud = 0;

    public Corredor(int longitudCarrera){
        this.longitud = longitudCarrera;
    }

    @Override
    public void run() {

        String threadName = Thread.currentThread().getName();
        for (int i=0; i<longitud; i++) {
            try {
                System.out.println(threadName + " recorrio " + i + " mts");
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("A mi no se me interrumpe");
            }
        }
        System.out.println( threadName + " termino ");
    }


}
