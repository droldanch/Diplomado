package irolso.com.ejercicio.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import irolso.com.ejercicio.Adapter.AdapterItem;
import irolso.com.ejercicio.Model.Modelitem;
import irolso.com.ejercicio.R;


public class FragmentList extends Fragment  {
    private ListView lv;
    private ListView listView;
    private EditText mItem;
    private List<Modelitem> array = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list,container,false);

        listView = (ListView) view.findViewById(R.id.itemList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AdapterItem adapter= (AdapterItem) parent.getAdapter();
                Modelitem modelItem =adapter.getItem(position);
                Modelitem modelItem2 = array.get(position);
            }
        });


        final EditText mItemsText = (EditText) view.findViewById(R.id.EditItem);
        view.findViewById(R.id.btnAddItem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemData = mItemsText.getText().toString();
                if(!TextUtils.isEmpty(itemData))
                {

                }

            }
        });
        return view;
    }
}
