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
import irolso.com.lifesadventure.model.ViajeGuardado;
import irolso.com.lifesadventure.sql.DataSource;


public class fragmentNuevo extends Fragment {

    @BindView(R.id.titleNasa)
    TextView title;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.explanation)
    TextView explanation;
    @BindView(R.id.copyRight)
    TextView copyright;
    @BindView(R.id.imageView_NewTravel)
    ImageView imagenView_NewTravel;
    String link = "";
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_nuevo, container, false);
        unbinder = ButterKnife.bind(this, view);

        DataSource dataSource = new DataSource(getActivity());
        ViajeGuardado viajeGuardado = new ViajeGuardado();
        viajeGuardado = dataSource.getFavoritos();
        title.setText(viajeGuardado.getName());
        date.setText(viajeGuardado.getStartDate());
        explanation.setText(viajeGuardado.getObservations());
        copyright.setText(viajeGuardado.getPlaceTime());
        Picasso.with(getActivity()).load(viajeGuardado.getPicture()).into(imagenView_NewTravel);
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

