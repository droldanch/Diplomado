package irolso.com.lifesadventure;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import irolso.com.lifesadventure.CustomsElements.TextViewBlack;
import irolso.com.lifesadventure.CustomsElements.TextViewMedium;
import irolso.com.lifesadventure.model.ViajeGuardado;
import irolso.com.lifesadventure.sql.DataSource;

public class DetailActivity extends AppCompatActivity {


    @BindView(R.id.toolbar_layout_detail)
    CollapsingToolbarLayout toolbar_layout_detail;

    @BindView(R.id.imageView_layout_detail)
    ImageView imageView_layout_detail;
    @BindView(R.id.textViewBlackDetailTitle)
    TextViewBlack textViewBlackDetailTitle;
    @BindView(R.id.textViewBlackDetailObservations)
    TextViewMedium textViewBlackDetailObservations;
    @BindView(R.id.textViewBlackDetailPrice)
    TextViewMedium textViewBlackDetailPrice;
    @BindView(R.id.textViewBlackDetailPlaceTimeDeparture)
    TextViewMedium textViewBlackDetailPlaceTimeDeparture;
    @BindView(R.id.textViewBlackDetailPlaceToVisit)
    TextViewMedium textViewBlackDetailPlaceToVisit;
    @BindView(R.id.textViewBlackDetailDate)
    TextViewMedium textViewBlackDetailDate;

    String oldFormat= "yyyy-MM-dd HH:mm:ss";
    String newFormat= "dd MMM yyyy ";
    ViajeGuardado viaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datail);
        ButterKnife.bind(this);

        Bundle bundle = this.getIntent().getExtras();

        Picasso.with(this).load("http://"+bundle.getString("url")).into(imageView_layout_detail);
        textViewBlackDetailTitle.setText(bundle.getString("name"));
        textViewBlackDetailObservations.setText("\n"+ bundle.getString("observations"));
        textViewBlackDetailPrice.setText("\n$ "+bundle.getString("price"));
        textViewBlackDetailPlaceTimeDeparture.setText("\n" +bundle.getString("placeTime"));
        textViewBlackDetailPlaceToVisit.setText("\n" +bundle.getString("placeToVisit"));
        textViewBlackDetailDate.setText(changeFormat(bundle.getString("date")));


            viaje = new ViajeGuardado();
            viaje.setName(bundle.getString("name"));
            viaje.setObservations(bundle.getString("observations"));
            viaje.setPrice(bundle.getString("price"));
            viaje.setPlaceTime(bundle.getString("placeTime"));
            viaje.setplaceToVisit(bundle.getString("placeToVisit"));
            viaje.setStartDate(changeFormat(bundle.getString("date")));
            viaje.setEndDate(changeFormat(bundle.getString("date2")));
            viaje.setPicture("http://"+bundle.getString("url"));
            viaje.setDetalles("Detalles");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataSource dataSource = new DataSource(DetailActivity.this);
                dataSource.saveTravels(viaje);
                Snackbar.make(findViewById(R.id.content_detail_all),getResources().getString(R.string.agregado), Snackbar.LENGTH_LONG).show();
            }
        });
    }

    public String changeFormat(String mStringDate){
        String formatedDate = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat(oldFormat);
        Date myDate = null;
        try {
            myDate = dateFormat.parse(mStringDate);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat timeFormat = new SimpleDateFormat(newFormat);
        formatedDate = timeFormat.format(myDate);
        return  formatedDate;
    }
}
