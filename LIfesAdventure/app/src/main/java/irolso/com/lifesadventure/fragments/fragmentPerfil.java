package irolso.com.lifesadventure.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import irolso.com.lifesadventure.R;

public class fragmentPerfil extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

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



