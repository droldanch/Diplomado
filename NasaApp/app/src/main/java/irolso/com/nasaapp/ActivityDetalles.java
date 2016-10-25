package irolso.com.nasaapp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import irolso.com.nasaapp.model.PhotoBD;
import irolso.com.nasaapp.sql.DataSource;

public class ActivityDetalles extends AppCompatActivity {

    @BindView(R.id.toolbarDetails)
    Toolbar toolbar;
    @BindView(R.id.titleNasaListDetalle)
    TextView titleNasaDetalle;
    @BindView(R.id.imageNasaListDetalle)
    SimpleDraweeView imageNasaDetalle;
    @BindView(R.id.nasaFechaDetalle)
    TextView fechaNasaDetalle;
    @BindView(R.id.fullNameContentDetalle)
    TextView fullname;
    PhotoBD photoBD;
    DataSource dataSource;
    public boolean guardado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        ButterKnife.bind(this);
        toolbar.setTitle(R.string.SpaceDR);
        setSupportActionBar(toolbar);
        dataSource = new DataSource(this);
        Bundle bundle = this.getIntent().getExtras();
        Picasso.with(this).load(bundle.getString("imagen")).into(imageNasaDetalle);
        fullname.setText(bundle.getString("contenido"));
        titleNasaDetalle.setText(bundle.getString("titleNasa"));
        fechaNasaDetalle.setText(bundle.getString("fecha"));
        photoBD = new PhotoBD();
        photoBD.Contenido = bundle.getString("contenido");
        photoBD.Imagen = bundle.getString("imagen");
        photoBD.Titulo = bundle.getString("titleNasa");
        photoBD.Fecha = bundle.getString("fecha");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menulist, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(!guardado) {
        switch (item.getItemId()) {

            case R.id.menu_share_list_apod:

                    dataSource.saveFavoritos(photoBD);
                    Snackbar.make(this.findViewById(R.id.detalles_container), "Guardada en Favoritos", Snackbar.LENGTH_SHORT).show();
                    guardado= true;
                break;
        }

        }else{
        Snackbar.make(this.findViewById(R.id.detalles_container), "Ya esta en tus Favoritos", Snackbar.LENGTH_SHORT).show();}
        return true;
    }
}
