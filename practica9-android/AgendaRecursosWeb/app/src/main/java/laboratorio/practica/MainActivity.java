package laboratorio.practica;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import laboratorio.practica.adapters.MiAdaptadorConIcono;
import laboratorio.practica.modelo.RecursoWeb;
import laboratorio.practica.modelo.TipoRecurso;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private RecursoWeb[] values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        values = new RecursoWeb[]{
                new RecursoWeb(0, "Fantasma", "http://www.sonidosmp3gratis.com/sounds/ruido_1.mp3", "Ruido fantasmagórico", TipoRecurso.AUDIO),
                new RecursoWeb(0, "Campanas", "http://www.sonidosmp3gratis.com/sounds/campanas_3.mp3", "Sonido de camapandas", TipoRecurso.AUDIO),
                new RecursoWeb(0, "Instagram", "http://www.instagram.com", "Sitio Oficial de Instagram", TipoRecurso.SITIO_WEB),
                new RecursoWeb(0, "Guitarra", "https://d1aeri3ty3izns.cloudfront.net/media/44/448686/1200/preview.jpg", "Guitarra PRS", TipoRecurso.IMAGEN)

        };


        this.setListView((ListView) this.findViewById(R.id.listaRecursos));
        //this.getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        //this.getListView().setAdapter(new ArrayAdapter<RecursoWeb>(this, android.R.layout.simple_list_item_single_choice, android.R.id.text1, values));

        MiAdaptadorConIcono adapter = new MiAdaptadorConIcono( this, values);
        this.getListView().setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                RecursoWeb item = (RecursoWeb) listView.getItemAtPosition(position);
                Intent webIntent = new Intent(Intent.ACTION_VIEW);
                webIntent.setData(Uri.parse(item.getUrl()));
                startActivity(webIntent);
                return false;
            }
        });
    }


    public ListView getListView() {
        return listView;
    }

    public void setListView(ListView listView) {
        this.listView = listView;
    }
}
