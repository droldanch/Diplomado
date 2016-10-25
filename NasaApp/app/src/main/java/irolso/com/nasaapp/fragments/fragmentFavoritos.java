package irolso.com.nasaapp.fragments;

import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import irolso.com.nasaapp.R;
import irolso.com.nasaapp.adapter.NasaApodAdapterDB;
import irolso.com.nasaapp.sql.DataSource;

/**
 * Created by Roldan on 12/08/16.
 */
public class fragmentFavoritos extends Fragment {



    @BindView(R.id.recyclerViewList)
    RecyclerView recyclerView;
    private Unbinder unbinder;
    DataSource dataSource;
    NasaApodAdapterDB nasaApodAdapterDB;
   /* @BindView(R.id.toolbarMain)
    Toolbar toolbarMain;*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.recycler_view, container, false);
        unbinder = ButterKnife.bind(this, view);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getActivity(), 1);
        dataSource = new DataSource(getActivity());
        recyclerView.setLayoutManager(gridLayoutManager);
        DataSource dataSource = new DataSource(getActivity());
        dataSource.getFavoritos();
        nasaApodAdapterDB = new NasaApodAdapterDB();
        nasaApodAdapterDB.setApods(dataSource.getFavoritos());
        recyclerView.setAdapter(nasaApodAdapterDB);

        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menulistfavoritos, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_share_list_apod:
                Dialog(R.string.borrarFavoritos);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void Dialog(int messege) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
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
                }).create().show();

    }
}
