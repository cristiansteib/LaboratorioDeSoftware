package laboratorio.practica;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

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

        final FloatingActionButton button = findViewById(R.id.floatingActionButton2);
;

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        values = new RecursoWeb[]{
                new RecursoWeb(0, "Fantasma", "http://www.sonidosmp3gratis.com/sounds/ruido_1.mp3", "Ruido fantasmagórico", TipoRecurso.AUDIO),
                new RecursoWeb(0, "Campanas", "http://www.sonidosmp3gratis.com/sounds/campanas_3.mp3", "Sonido de camapandas", TipoRecurso.AUDIO),
                new RecursoWeb(0, "Instagram", "http://www.instagram.com", "Sitio Oficial de Instagram", TipoRecurso.SITIO_WEB),
                new RecursoWeb(0, "Guitarra", "https://d1aeri3ty3izns.cloudfront.net/media/44/448686/1200/preview.jpg", "Guitarra PRS", TipoRecurso.IMAGEN)

        };

        this.setListView((ListView) this.findViewById(R.id.listaRecursos));

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

        // Callback de floatingButton para compartir los recursos.
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String shareBody = "";
                for (RecursoWeb value:values){
                    shareBody = shareBody.concat(value.toString()).concat("\n");
                }
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Sharing multimedia resources");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, getResources().getString(R.string.share_using)));
            }
        });

    }

    private View.OnClickListener btnListener = new View.OnClickListener()
    {

        public void onClick(View v)
        {
            //Intent newPicIntent = new Intent(v.getContext(), NewPictureActivity.class);
            //startActivityForResult(newPicIntent, 0);
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, 999);
        }

    };

    public ListView getListView() {
        return listView;
    }

    public void setListView(ListView listView) {
        this.listView = listView;
    }
}
