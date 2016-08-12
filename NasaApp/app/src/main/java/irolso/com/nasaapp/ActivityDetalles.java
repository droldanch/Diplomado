package irolso.com.nasaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import irolso.com.nasaapp.model.Photo;

public class ActivityDetalles extends AppCompatActivity {


    @BindView(R.id.titleNasaListDetalle)
    TextView titleNasaDetalle;
    @BindView(R.id.imageNasaListDetalle)
    SimpleDraweeView imageNasaDetalle;
    @BindView(R.id.nasaFechaDetalle)
    TextView fechaNasaDetalle;
    @BindView(R.id.fullNameContentDetalle)
    TextView fullname;

    Photo photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        ButterKnife.bind(this);
        photo = new Photo();

        Bundle bundle = this.getIntent().getExtras();
       // photo = (Photo) bundle.getSerializable("Photo");
      //  photo.getImgSrc();
        Picasso.with(this).load(bundle.getString("imagen")).into(imageNasaDetalle);

        fullname.setText(bundle.getString("contenido"));
        titleNasaDetalle.setText(bundle.getString("titleNasa"));
        fechaNasaDetalle.setText(bundle.getString("fecha"));
    }
}
