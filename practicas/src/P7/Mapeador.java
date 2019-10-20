package P7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

import static java.lang.Class.forName;

public class Mapeador {

    public static void main(String[] args) {

        String className = (args.length > 0) ? args[0] : "P7.Bean";

        try {
            Class<?> classToMap = forName(className);
            String fileName;
            fileName = classToMap.getAnnotation(Archivo.class).name();
            if (fileName.equals("")) {
                fileName = classToMap.getSimpleName() + ".txt";
            }
            FileWriter file = new FileWriter(fileName, false);   //el true hace append
            BufferedWriter bw = new BufferedWriter(file);
            //Bean bean = new Bean();
            bw.write("<nombreClase>" + classToMap.getSimpleName() + "</nombreClase>");
            bw.newLine();
            for (Field f : classToMap.getDeclaredFields()) {
                if (f.isAnnotationPresent(AlmacenarAtributo.class)) {
                    bw.write("<nombreAtributo>" + f.getName() + "</nombreAtributo>");
                    bw.newLine();
                    f.setAccessible(true);
                    bw.write("<nombreValor>" + f.get(classToMap.newInstance()) + "</nombreValor>");
                    bw.newLine();
                }
            }
            bw.close();
        } catch (ClassNotFoundException e) {
            System.out.println("no se encontro la clase");
        } catch (IOException e) {
            System.out.println("ohoh... ");
        } catch (IllegalAccessException e) {
            System.out.println("ups... ");
        } catch (InstantiationException e) {
            System.out.println("No existe el metodo");
        }
    }
}
