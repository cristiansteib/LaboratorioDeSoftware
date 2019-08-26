
public class Estudiante {

    private String apellido="";
    private String nombre="";
    private String legajo="";

    @Override
    public String toString() {
        StringBuffer concatenacion = new StringBuffer("");
        concatenacion.append(this.nombre);
        concatenacion.append(this.apellido);
        concatenacion.append(this.legajo);
        return concatenacion.toString();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public static void main(String[] args) {
        Estudiante e = new Estudiante();
        e.setNombre("juan");
        e.setApellido("morales");
        e.setLegajo("123123");
        System.out.println(e);
    }
}