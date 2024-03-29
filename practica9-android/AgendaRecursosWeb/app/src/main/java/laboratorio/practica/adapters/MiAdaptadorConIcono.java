package laboratorio.practica.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import laboratorio.practica.R;
import laboratorio.practica.modelo.RecursoWeb;


public class MiAdaptadorConIcono extends ArrayAdapter<RecursoWeb> {
    private final Context context;
    private final RecursoWeb[] values;

    public MiAdaptadorConIcono(Context context, RecursoWeb[] values) {
        super(context, R.layout.recurso_iconico, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.recurso_iconico, parent, false);
        ImageView image = rowView.findViewById(R.id.imgView);
        TextView text = rowView.findViewById(R.id.textView);
        image.setImageResource(values[position].getIcon());
        text.setText(values[position].getNombre());
        return rowView;
    }
}