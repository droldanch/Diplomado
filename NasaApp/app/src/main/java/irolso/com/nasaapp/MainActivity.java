package irolso.com.nasaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import irolso.com.nasaapp.data.ApodService;
import irolso.com.nasaapp.data.Data;
import irolso.com.nasaapp.model.RespuestaJson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView title,date,explanation,copyright;
    ImageView imagenNasa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        imagenNasa = (ImageView) findViewById(R.id.imageNasa);
        title = (TextView) findViewById(R.id.titleNasa);
        date = (TextView) findViewById(R.id.date);
        explanation = (TextView) findViewById(R.id.explanation);
        copyright = (TextView) findViewById(R.id.copyRight);


        ApodService apodService = Data.getRetrofitInstance().create(ApodService.class);
        Call<RespuestaJson> callApodService = apodService.getTodayApod();

        callApodService.enqueue(new Callback<RespuestaJson>() {


            @Override
            public void onResponse(Call<RespuestaJson> call, Response<RespuestaJson> response) {
                //  Log.d("APOD",response.body().getTitle());

                title.setText(response.body().getTitle().toString());
                date.setText(response.body().getDate().toString());
                explanation.setText(response.body().getExplanation().toString());
                copyright.setText(response.body().getCopyright().toString());
                Picasso.with(MainActivity.this).load(response.body().getHdurl().toString()).into(imagenNasa);

            }

            @Override
            public void onFailure(Call<RespuestaJson> call, Throwable t) {

            }

        });

    }
}


