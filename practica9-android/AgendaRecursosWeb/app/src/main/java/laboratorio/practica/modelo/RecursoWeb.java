package laboratorio.practica.modelo;

public abstract class RecursoWeb {

    private Integer id;
    private String nombre;
    private String url;
    private String comentario;


    public RecursoWeb(Integer id, String nombre, String url, String comentario) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.url = url;
        this.comentario = comentario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {

        return nombre + " : " + url;
    }


    public abstract int getIcon();
}
