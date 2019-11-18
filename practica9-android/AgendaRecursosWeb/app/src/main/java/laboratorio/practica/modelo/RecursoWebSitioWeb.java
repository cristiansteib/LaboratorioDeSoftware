package laboratorio.practica.modelo;

import laboratorio.practica.R;

public class RecursoWebSitioWeb extends RecursoWeb {


    public RecursoWebSitioWeb(Integer id, String nombre, String url, String comentario) {
        super(id, nombre, url, comentario);
    }

    public int getIcon(){
        return R.drawable.globe;
    }
}
