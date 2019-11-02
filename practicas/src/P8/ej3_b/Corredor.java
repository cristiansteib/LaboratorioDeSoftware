package P8.ej3_b;


import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Corredor implements Callable<Long> {

    private int longitud = 0;

    public Corredor(){
        this.longitud = 100;
    }


    /***
     * <p>The {@code Callable} interface is similar to {@link
     * java.lang.Runnable}, in that both are designed for classes whose
     * instances are potentially executed by another thread.  A
     * {@code Runnable}, however, does not return a result and cannot
     * throw a checked exception.**/
    @Override
    public Long call() {

        String threadName = Thread.currentThread().getName();
        for (int i=0; i<longitud; i++) {
            try {
                System.out.println(threadName + " recorrio " + i + " mts");
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("A mi no se me interrumpe");
            }
        }
        System.out.println( threadName + " termino ");
        return Thread.currentThread().getId();
    }


}
