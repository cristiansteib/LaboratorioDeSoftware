package laboratorio.practica.modelo;

import laboratorio.practica.R;

public class RecursoWebImagen extends RecursoWeb {


    public RecursoWebImagen(Integer id, String nombre, String url, String comentario) {
        super(id, nombre, url, comentario);
    }

    public int getIcon(){
        return R.drawable.picture;
    }
}
