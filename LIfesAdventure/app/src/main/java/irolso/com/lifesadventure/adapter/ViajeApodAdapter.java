package irolso.com.lifesadventure.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import irolso.com.lifesadventure.R;
import irolso.com.lifesadventure.Response.ResponselistEvent;

/**
 * Created by Roldan on 25/10/16.
 */

public class ViajeApodAdapter extends RecyclerView.Adapter<ViajeApodViewHolder> {

    private List<ResponselistEvent> apods;
    private OnItemClickListener onItemClickListener;
    String oldFormat= "yyyy-MM-dd HH:mm:ss";
    String newFormat= "dd MMM yyyy ";
    public ViajeApodAdapter(){}
    public ViajeApodAdapter(List<ResponselistEvent> apods)
    {this.apods = apods;}

    @Override
    public ViajeApodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViajeApodViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viaje_apod_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViajeApodViewHolder holder, int position) {
        ResponselistEvent viaje = apods.get(position);
        Picasso.with(holder.imageNasa.getContext()).load("http://"+viaje.getPictures().get(0).getUrl()).into(holder.imageNasa);
        holder.descriptionImagenTravel.setText(viaje.getName());
        holder.descriptionImagenTravel2.setText(viaje.getPlaceToVisit());
        holder.dateTravel.setText(changeFormat(viaje.getStartDate().getDate()));
        holder.priceTravel.setText("$ "+viaje.getPrice());
        holder.setItemCLick(viaje,onItemClickListener);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setApods(List<ResponselistEvent> apods) {
        this.apods = apods;
    }


    @Override
    public int getItemCount() {
        return apods !=null ? apods.size():0;
    }

    public interface OnItemClickListener{
        void onItemCLick(ResponselistEvent viaje);
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

