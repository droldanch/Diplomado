package irolso.com.lifesadventure.fragments;

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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import irolso.com.lifesadventure.Data.ApodService;
import irolso.com.lifesadventure.Data.Data;
import irolso.com.lifesadventure.DetailActivity;
import irolso.com.lifesadventure.R;
import irolso.com.lifesadventure.Response.ResponselistEvent;
import irolso.com.lifesadventure.adapter.ViajeApodAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class fragmentViajes extends Fragment {


    @BindView(R.id.recyclerViewList)
    RecyclerView recyclerView;
    private Unbinder unbinderViajes;
    List<ResponselistEvent> viajeItemList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_viajes, container, false);
        unbinderViajes = ButterKnife.bind(this, view);

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getActivity(),1);

        viajeItemList = new ArrayList<>();
        recyclerView.setLayoutManager(gridLayoutManager);
        final ViajeApodAdapter viajeApodAdapter = new ViajeApodAdapter();

        viajeApodAdapter.setOnItemClickListener(new ViajeApodAdapter.OnItemClickListener() {
            @Override
            public void onItemCLick(ResponselistEvent viaje) {
                Intent intentDetail = new Intent(getActivity(),DetailActivity.class);
                intentDetail.putExtra("id",viaje.getId());
                intentDetail.putExtra("name", viaje.getName());
                intentDetail.putExtra("observations", viaje.getObservations());
                intentDetail.putExtra("date",viaje.getStartDate().getDate());
                intentDetail.putExtra("date2",viaje.getEndDate().getDate());
                intentDetail.putExtra("url",viaje.getPictures().get(0).getUrl());
                intentDetail.putExtra("price",viaje.getPrice());
                intentDetail.putExtra("placeTime",viaje.getPlaceTimeDeparture());
                intentDetail.putExtra("placeToVisit",viaje.getPlaceToVisit());
                startActivity(intentDetail);
            }
        });

        ApodService apodService = Data.getRetrofitInstance().create(ApodService.class);

        apodService.listEvent().enqueue(new Callback<List<ResponselistEvent>>() {
            @Override
            public void onResponse(Call<List<ResponselistEvent>> call, Response<List<ResponselistEvent>> response) {


                viajeApodAdapter.setApods(response.body());
                recyclerView.setAdapter(viajeApodAdapter);

            }

            @Override
            public void onFailure(Call<List<ResponselistEvent>> call, Throwable t) {

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
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}



