package irolso.com.ejercicio.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import irolso.com.ejercicio.Model.Modelitem;
import irolso.com.ejercicio.R;

/**
 * Created by Roldan on 19/06/16.
 */
public class AdapterItem extends ArrayAdapter<Modelitem> {


    public AdapterItem(Context context, List<Modelitem> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)

        convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item,parent,false);

        TextView id = (TextView) convertView.findViewById(R.id.row_item_id);
        TextView item = (TextView) convertView.findViewById(R.id.row_item_name);
        Modelitem data = (Modelitem) getItem(position);
        id.setText(String.valueOf(data.id));
        item.setText(data.name);

        return convertView;
    }
}

