
public class Estudiante {

    private String apellido="";
    private String nombre="";
    private String legajo="";

    @Override
    public String toString() {
        StringBuffer concatenacion = new StringBuffer("");
        concatenacion.append(this.nombre);
        concatenacion.append(" ");
        concatenacion.append(this.apellido);
        concatenacion.append(" ");
        concatenacion.append(this.legajo);
        return concatenacion.toString();
    }
        
    @Override
    public boolean equals(Object arg0) {
    	Estudiante e = (Estudiante) arg0;
    	return (e.getLegajo() == this.getLegajo());
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

 
}