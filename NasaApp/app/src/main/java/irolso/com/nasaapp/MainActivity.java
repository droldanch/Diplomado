package irolso.com.nasaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import irolso.com.nasaapp.adapter.NasaApodAdapter;
import irolso.com.nasaapp.data.ApodService;
import irolso.com.nasaapp.data.Data;
import irolso.com.nasaapp.model.Example;
import irolso.com.nasaapp.model.Photo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //TextView title,date,explanation,copyright;
  //  ImageView imagenNasa;

    @BindView(R.id.recyclerViewList)
    RecyclerView recyclerView;

    @BindView(R.id.toolbarMain)
    Toolbar toolbarMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        ButterKnife.bind(this);
        setSupportActionBar(toolbarMain);
        toolbarMain.setTitle("Nasa App");
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);

        recyclerView.setLayoutManager(gridLayoutManager);

        final NasaApodAdapter nasaApodAdapter = new NasaApodAdapter();

        nasaApodAdapter.setOnItemClickListener(new NasaApodAdapter.OnItemClickListener(){


            @Override
            public void onItemCLick(Photo photo) {

                Intent intent = new Intent(MainActivity.this, ActivityDetalles.class);

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

        apodService.getTodayApodWithQuery2("1000",BuildConfig.API_KEY).enqueue(new Callback<Example>() {

            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
               // Log.d("APOD", String.valueOf(response.body().getPhotos()));
                /*title.setText(response.body().getPhotos().toString());
                date.setText(response.body().getDate().toString());
                explanation.setText(response.body().getExplanation().toString());
                copyRight.setText(response.body().getCopyright().toString());
                Picasso.with(MainActivity.this).load(response.body().getHdurl().toString()).into(imagenNasa);
*/              nasaApodAdapter.setApods(response.body().getPhotos());
                recyclerView.setAdapter(nasaApodAdapter);

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }

        });

    }


}


