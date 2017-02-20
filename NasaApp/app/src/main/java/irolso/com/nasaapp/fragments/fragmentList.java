package irolso.com.nasaapp.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
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
import irolso.com.nasaapp.BuildConfig;
import irolso.com.nasaapp.R;
import irolso.com.nasaapp.adapter.NasaApodAdapter;
import irolso.com.nasaapp.data.ApodService;
import irolso.com.nasaapp.data.Data;
import irolso.com.nasaapp.model.Example;
import irolso.com.nasaapp.model.Photo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Roldan on 12/08/16.
 */
public class fragmentList extends Fragment {



    @BindView(R.id.recyclerViewList)
    RecyclerView recyclerView;
    private Unbinder unbinder;

   /* @BindView(R.id.toolbarMain)
    Toolbar toolbarMain;*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.recycler_view,container,false);
        unbinder = ButterKnife.bind(this, view);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getActivity(),1);

        recyclerView.setLayoutManager(gridLayoutManager);

        final NasaApodAdapter nasaApodAdapter = new NasaApodAdapter();

        nasaApodAdapter.setOnItemClickListener(new NasaApodAdapter.OnItemClickListener(){

            @Override
            public void onItemCLick(Photo photo) {

                Intent intent = new Intent();

                //   Bundle bundle = new Bundle();
                //  bundle.putSerializable("photo", photo);
                //  intent.putExtras(bundle);

                intent.putExtra("imagen",photo.getImgSrc());
                intent.putExtra("titleNasa", photo.getRover().getName());
                intent.putExtra("fecha",photo.getEarthDate());
                intent.putExtra("contenido",photo.getCamera().getFullName());
                startActivity(intent);
            }
        });


        ApodService apodService = Data.getRetrofitInstance().create(ApodService.class);

        apodService.getTodayApodWithQuery2("1000", BuildConfig.API_KEY).enqueue(new Callback<Example>() {

            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                // Log.d("APOD", String.valueOf(response.body().getPhotos()));
               /* title.setText(response.body().getPhotos().toString());
                date.setText(response.body().getDate().toString());
                explanation.setText(response.body().getExplanation().toString());
                copyRight.setText(response.body().getCopyright().toString());
                Picasso.with(MainActivity.this).load(response.body().getHdurl().toString()).into(imagenNasa);
*/            nasaApodAdapter.setApods(response.body().getPhotos());
                recyclerView.setAdapter(nasaApodAdapter);

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }

        });
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menulist2, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_share_list_apod:
              //  Snackbar.make(getActivity().findViewById(R.id.main_container),"",Snackbar.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
