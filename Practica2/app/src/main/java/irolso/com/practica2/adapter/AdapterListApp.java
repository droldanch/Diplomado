package irolso.com.practica2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

import irolso.com.practica2.R;
import irolso.com.practica2.model.ModelListApp;

/**
 * Created by Roldan on 06/07/16.
 */
public class AdapterListApp extends ArrayAdapter<ModelListApp> {


    public AdapterListApp (Context context, List<ModelListApp> objects) {
        super(context, 0, objects);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista_app,parent,false);
        }

        ImageView imagenApp = (ImageView) convertView.findViewById(R.id.AdapterListAppButton);
        TextView textApp = (TextView) convertView.findViewById(R.id.AdapterListAppNombre);
        TextView textDesarrollador = (TextView) convertView.findViewById(R.id.AdapterListAppDesarrollador);
        TextView textLeyenda = (TextView) convertView.findViewById(R.id.AdapterListAppUpdate);




        ModelListApp modelItem = getItem(position);
        int i1 = modelItem.Imagen;
        String url;
        switch (i1){
            case 1:
                url="http://www.dalipaintings.net/images/paintings/the-persistence-of-memory.jpg";
                Picasso.with(getContext()).load(url).resize(300, 300).centerCrop().into(imagenApp);

                break;
            case 2:
                url="http://www.dalipaintings.net/images/paintings/swans-reflecting-elephants.jpg";
                Picasso.with(getContext()).load(url).resize(300, 300).centerCrop().into(imagenApp);
                break;
            case 3:
                url="http://www.dalipaintings.net/images/paintings/swans-reflecting-elephants.jpg";
                Picasso.with(getContext()).load(url).resize(300, 300).centerCrop().into(imagenApp);
                break;
            case 4:
                url="http://www.dalipaintings.net/images/paintings/the-disintegration-of-the-persistence-of-memory.jpg";
                Picasso.with(getContext()).load(url).resize(300, 300).centerCrop().into(imagenApp);
                break;
            case 5:
                url="http://www.dalipaintings.net/images/paintings/dream-caused-by-the-flight-of-a-bee.jpg";
                Picasso.with(getContext()).load(url).resize(300, 300).centerCrop().into(imagenApp);
                break;
            case 6:
                url="http://www.dalipaintings.net/images/paintings/the-temptation-of-saint-anthony.jpg";
                Picasso.with(getContext()).load(url).resize(300, 300).centerCrop().into(imagenApp);
                break;
            case 7:
                url="http://www.dalipaintings.net/images/paintings/the-madonna-of-port-lligat.jpg";
                Picasso.with(getContext()).load(url).resize(300, 300).centerCrop().into(imagenApp);
                break;
            case 8:
                url="http://www.dalipaintings.net/images/paintings/bacchanale.jpg";
                Picasso.with(getContext()).load(url).resize(300, 300).centerCrop().into(imagenApp);
                break;
            case 9:
                url="http://www.dalipaintings.net/images/paintings/christ-of-saint-john-of-the-cross.jpg";
                Picasso.with(getContext()).load(url).resize(300, 300).centerCrop().into(imagenApp);
                break;
            default:
                url="http://www.dalipaintings.net/images/paintings/christ-of-saint-john-of-the-cross.jpg";
                Picasso.with(getContext()).load(url).resize(300, 300).centerCrop().into(imagenApp);
                break;
        }

        textApp.setText(modelItem.Nombre);
        textDesarrollador.setText(modelItem.Desarrollador);
        if(modelItem.Update == 0)
        textLeyenda.setText(getContext().getString(R.string.intalada));
        else
            textLeyenda.setText(getContext().getString(R.string.actualizada));


        return convertView;
    }

}

