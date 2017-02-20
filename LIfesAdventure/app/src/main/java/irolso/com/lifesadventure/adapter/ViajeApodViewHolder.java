package irolso.com.lifesadventure.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import irolso.com.lifesadventure.R;
import irolso.com.lifesadventure.Response.ResponselistEvent;

/**
 * Created by Roldan on 25/10/16.
 */

public class ViajeApodViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.descriptionImagenTravel)
    TextView descriptionImagenTravel;
    @BindView(R.id.descriptionImagenTravel2)
    TextView descriptionImagenTravel2;
    @BindView(R.id.imageNasaList)
    ImageView imageNasa;
    @BindView(R.id.dateTravel)
    TextView dateTravel;
    @BindView(R.id.priceTravel)
    TextView priceTravel;

    private ViajeApodAdapter.OnItemClickListener onItemClickListener;
    private ResponselistEvent viaje;

    public ViajeApodViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void setItemCLick(ResponselistEvent viaje, ViajeApodAdapter.OnItemClickListener onItemClickListener){
        this.viaje = viaje;
        this.onItemClickListener = onItemClickListener;
    }

    @OnClick(R.id.imageNasaList)
    public void onViewClick(View view){
        if(onItemClickListener!=null)
            onItemClickListener.onItemCLick(viaje);
    }
}

