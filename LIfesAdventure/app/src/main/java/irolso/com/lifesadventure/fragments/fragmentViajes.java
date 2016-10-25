package irolso.com.lifesadventure.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import irolso.com.lifesadventure.R;
import irolso.com.lifesadventure.adapter.ViajeApodAdapter;
import irolso.com.lifesadventure.model.Viaje;


public class fragmentViajes extends Fragment {


    @BindView(R.id.recyclerViewList)
    RecyclerView recyclerView;
    private Unbinder unbinder;
    List<Viaje> viajeItemList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_viajes, container, false);
        unbinder = ButterKnife.bind(this, view);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getActivity(),2);

        viajeItemList = new ArrayList<>();

        Viaje modelItem = new Viaje();
        modelItem.setId(1);
        modelItem.setTitle("Destino");
        modelItem.setDate("Fecha");
        modelItem.setExplanation("Descripcion");
        modelItem.setExtra("Fecha");
        modelItem.setImagen("http://www.travelguia.net/wp-content/uploads/2008/10/dscn1355-50.jpg");
        viajeItemList.add(modelItem);

        Viaje modelItem2 = new Viaje();
        modelItem2.setId(2);
        modelItem2.setTitle("Destino 2");
        modelItem2.setDate("Fecha");
        modelItem2.setExplanation("Descripcion");
        modelItem2.setExtra("Fecha");
        modelItem2.setImagen("https://s-media-cache-ak0.pinimg.com/736x/df/01/2a/df012acb82ef4e6b6b716e429d822c0b.jpg");
        viajeItemList.add(modelItem2);

        Viaje modelItem3 = new Viaje();
        modelItem3.setId(3);
        modelItem3.setTitle("Destino 3");
        modelItem3.setDate("Fecha");
        modelItem3.setExplanation("Descripcion");
        modelItem3.setExtra("Fecha");
        modelItem3.setImagen("https://s-media-cache-ak0.pinimg.com/736x/fd/ba/f6/fdbaf69fe5ea6c54e74858abbad4f4be.jpg");
        viajeItemList.add(modelItem3);

        Viaje modelItem4 = new Viaje();
        modelItem4.setId(1);
        modelItem4.setTitle("Destino 4");
        modelItem4.setDate("Fecha");
        modelItem4.setExplanation("Descripcion");
        modelItem4.setExtra("Fecha");
        modelItem4.setImagen("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPz8x28Du3hCd_yrb_Yd3LF6HUZ6Blckdtc9Y9uHKyYIKTqY5kmQ");
        viajeItemList.add(modelItem4);

        Viaje modelItem5 = new Viaje();
        modelItem5.setId(1);
        modelItem5.setTitle("Destino 5");
        modelItem5.setDate("Fecha");
        modelItem5.setExplanation("Descripcion");
        modelItem5.setExtra("Fecha");
        modelItem5.setImagen("https://s-media-cache-ak0.pinimg.com/564x/12/04/e9/1204e973c5fd3f997c32c956b0ece99f.jpg");
        viajeItemList.add(modelItem5);

        Viaje modelItem6 = new Viaje();
        modelItem6.setId(1);
        modelItem6.setTitle("Destino 6");
        modelItem6.setDate("Fecha");
        modelItem6.setExplanation("Descripcion");
        modelItem6.setExtra("Fecha");
        modelItem6.setImagen("http://cdn1.matadornetwork.com/blogs/1/2011/11/Cenote-dive.jpg");
        viajeItemList.add(modelItem6);


        recyclerView.setLayoutManager(gridLayoutManager);
        final ViajeApodAdapter viajeApodAdapter = new ViajeApodAdapter();

        viajeApodAdapter.setApods(viajeItemList);
        recyclerView.setAdapter(viajeApodAdapter);

        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //inflater.inflate(R.menu.menulistfavoritos, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
       /*     case R.id.menu_share_list_apod:
                Dialog(R.string.borrarFavoritos);
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void Dialog(int messege) {

     /*   AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(messege)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dataSource.deleteFavoritos();
                        nasaApodAdapterDB.setApods(dataSource.getFavoritos());
                        recyclerView.setAdapter(nasaApodAdapterDB);

                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                }).create().show();*/

    }
}



