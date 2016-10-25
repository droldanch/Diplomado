package irolso.com.lifesadventure.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import irolso.com.lifesadventure.R;


public class fragmentNuevo extends Fragment {

    @BindView(R.id.titleNasa)
    TextView title;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.explanation)
    TextView explanation;
    @BindView(R.id.copyRight)
    TextView copyright;
    @BindView(R.id.imageNasa)
    ImageView imagenNasa;
    String link = "";
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_nuevo, container, false);
        unbinder = ButterKnife.bind(this, view);

        title.setText("Nombre Viaje");
        date.setText("30-10-2016");
        explanation.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        copyright.setText("Text");
        Picasso.with(getActivity()).load("http://www.reikal.com.mx/imagenes/company_photo/8795_big.jpg").into(imagenNasa);
        link="";


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

