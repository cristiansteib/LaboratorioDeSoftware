package laboratorio.practica.modelo;

import laboratorio.practica.R;

public class RecursoWebAudio extends RecursoWeb {

    public RecursoWebAudio(Integer id, String nombre, String url, String comentario) {
        super(id, nombre, url, comentario);
    }

    public int getIcon(){
        return R.drawable.sound;
    }
}
