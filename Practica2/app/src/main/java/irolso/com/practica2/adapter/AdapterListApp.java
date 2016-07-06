package irolso.com.practica2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

import irolso.com.practica2.R;
import irolso.com.practica2.model.ModelListApp;

/**
 * Created by Roldan on 06/07/16.
 */
public class AdapterListApp extends ArrayAdapter<ModelListApp> {

    public AdapterListApp (Context context, List<ModelListApp> objects) {
        super(context, 0, objects);

    }
    DecimalFormat currency = new DecimalFormat("$ ###,###.##");
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista_app,parent,false);
        }

        ImageButton imagenApp = (ImageButton) convertView.findViewById(R.id.AdapterListAppButton);
        TextView textApp = (TextView) convertView.findViewById(R.id.AdapterListAppNombre);
        TextView textDesarrollador = (TextView) convertView.findViewById(R.id.AdapterListAppDesarrollador);
        TextView textLeyenda = (TextView) convertView.findViewById(R.id.AdapterListAppLeyenda);


        ModelListApp modelItem = getItem(position);

        textApp.setText(modelItem.App);
        textDesarrollador.setText(modelItem.Desarrollador);
        textDesarrollador.setText(modelItem.Leyenda);

        return convertView;
    }

}

