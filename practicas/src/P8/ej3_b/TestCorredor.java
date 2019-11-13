package P8.ej3_b;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCorredor {

    static final private int LONGITUD_CARRERA = 100;
    public static void main(String[] args) {
        int THREADS = 3;

        ExecutorService exec = Executors.newFixedThreadPool(THREADS);
        ArrayList<Future> results = new ArrayList<Future>();

        for (int i = 0; i < 5; i++) {
            Future<Long> resultado = exec.submit(new Corredor());
            results.add(resultado);
        }

        // Espero a que todos los threads terminen y retornen algo
        ArrayList<Future> toRemove = new ArrayList<Future>();
        while (!results.isEmpty()) {
            for (Future<Long>resultado:
                 results) {
                if(resultado.isDone()) {
                    try {
                        System.out.println("RESULTADO POR PARAMETRO: ");
                        System.out.println(resultado.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (ThreadDeath e){
                        e.printStackTrace();
                    }
                    toRemove.add(resultado);
                }

            }
            results.removeAll(toRemove);
        }
        exec.shutdown();

    }
}
