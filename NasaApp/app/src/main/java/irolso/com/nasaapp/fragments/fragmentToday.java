package irolso.com.nasaapp.fragments;

import android.app.Fragment;
import android.content.Intent;
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
import irolso.com.nasaapp.ActivityDetalles;
import irolso.com.nasaapp.R;
import irolso.com.nasaapp.adapter.NasaApodAdapter;
import irolso.com.nasaapp.data.ApodService;
import irolso.com.nasaapp.data.Data;
import irolso.com.nasaapp.model.Photo;
import irolso.com.nasaapp.model.RespuestaJson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Roldan on 12/08/16.
 */
public class fragmentToday extends Fragment {

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

        View view = inflater.inflate(R.layout.activity_main, container, false);
        unbinder = ButterKnife.bind(this, view);

final NasaApodAdapter nasaApodAdapter = new NasaApodAdapter();

        nasaApodAdapter.setOnItemClickListener(new NasaApodAdapter.OnItemClickListener() {


@Override
public void onItemCLick(Photo photo) {

        Intent intent = new Intent(getActivity(), ActivityDetalles.class);

        //   Bundle bundle = new Bundle();
        //  bundle.putSerializable("photo", photo);
        //  intent.putExtras(bundle);

        intent.putExtra("imagen", photo.getImgSrc());
        intent.putExtra("titleNasa", photo.getRover().getName());
        intent.putExtra("fecha", photo.getEarthDate());
        intent.putExtra("contenido", photo.getCamera().getFullName());
        startActivity(intent);
        }
        });


        ApodService apodService = Data.getRetrofitInstance().create(ApodService.class);

        apodService.getTodayApod().enqueue(new Callback<RespuestaJson>() {

@Override
public void onResponse(Call<RespuestaJson> call, Response<RespuestaJson> response) {
        // Log.d("APOD", String.valueOf(response.body().getPhotos()));
        title.setText(response.body().getTitle().toString());
        date.setText(response.body().getDate().toString());
        explanation.setText(response.body().getExplanation().toString());
        copyright.setText(response.body().getCopyright().toString());
        Picasso.with(getActivity()).load(response.body().getHdurl().toString()).into(imagenNasa);
        link=response.body().getHdurl().toString();

        }

@Override
public void onFailure(Call<RespuestaJson> call, Throwable t) {

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
        inflater.inflate(R.menu.menutoday, menu);
        super.onCreateOptionsMenu(menu, inflater);
        }

@Override
public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.menu_share_today_apod:
                shareText(link);

        return true;
default:
        return super.onOptionsItemSelected(item);
        }
        }


private void shareText(String text){
        Intent shareText = new Intent(Intent.ACTION_SEND);
        shareText.setType("text/plain");
        shareText.putExtra(Intent.EXTRA_TEXT,text);
        startActivity(Intent.createChooser(shareText,getString(R.string.compartir)));
}


}

