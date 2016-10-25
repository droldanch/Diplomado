package irolso.com.lifesadventure.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import irolso.com.lifesadventure.R;
import irolso.com.lifesadventure.model.Viaje;

/**
 * Created by Roldan on 25/10/16.
 */

public class ViajeApodAdapter extends RecyclerView.Adapter<ViajeApodViewHolder> {

    private List<Viaje> apods;
    private OnItemClickListener onItemClickListener;

    public ViajeApodAdapter(){}
    public ViajeApodAdapter(List<Viaje> apods)
    {this.apods = apods;}

    @Override
    public ViajeApodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViajeApodViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viaje_apod_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViajeApodViewHolder holder, int position) {
        Viaje viaje = apods.get(position);
        Picasso.with(holder.imageNasa.getContext()).load(viaje.getImagen()).into(holder.imageNasa);
       // holder.imageNasa.setImageURI(viaje.getImagen());
        holder.contentNasa2.setText(viaje.getExplanation());
        holder.contentNasa.setText(viaje.getExtra());
        holder.titleNasa.setText(viaje.getTitle());
        holder.setItemCLick(viaje,onItemClickListener);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setApods(List<Viaje> apods) {
        this.apods = apods;
    }


    @Override
    public int getItemCount() {
        return apods !=null ? apods.size():0;
    }

    public interface OnItemClickListener{
        void onItemCLick(Viaje viaje);
    }
}

