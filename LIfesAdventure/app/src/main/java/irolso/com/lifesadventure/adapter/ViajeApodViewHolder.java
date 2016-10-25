package irolso.com.lifesadventure.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import irolso.com.lifesadventure.R;
import irolso.com.lifesadventure.model.Viaje;

/**
 * Created by Roldan on 25/10/16.
 */

public class ViajeApodViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.titleNasaList)
    TextView titleNasa;
    @BindView(R.id.imageNasaList)
    ImageView imageNasa;
    @BindView(R.id.titleNasaContent)
    TextView contentNasa;
    @BindView(R.id.titleNasaContent2)
    TextView contentNasa2;

    private ViajeApodAdapter.OnItemClickListener onItemClickListener;
    private Viaje viaje;

    public ViajeApodViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void setItemCLick(Viaje viaje, ViajeApodAdapter.OnItemClickListener onItemClickListener){
        this.viaje = viaje;
        this.onItemClickListener = onItemClickListener;
    }

    @OnClick(R.id.imageNasaList)
    public void onViewClick(View view){
        if(onItemClickListener!=null)
            onItemClickListener.onItemCLick(viaje);
    }
}

