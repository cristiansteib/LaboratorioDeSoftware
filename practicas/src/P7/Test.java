package P7;

public class Test {

    public static void main(String[] args) {
        String className = (args.length > 0) ? args[0] : "P7.Bean";
        Mapeador mapper = new Mapeador();
        mapper.mapear(className);
    }
}
