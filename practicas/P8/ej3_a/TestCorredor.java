package ej3_a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCorredor {

    static final private int LONGITUD_CARRERA = 100;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(3);
        for (int i=0; i < 5; i++){
            exec.execute(new Corredor(LONGITUD_CARRERA));
        }
        exec.shutdown();
    }
}
