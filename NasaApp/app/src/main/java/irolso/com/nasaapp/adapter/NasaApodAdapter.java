package irolso.com.nasaapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import irolso.com.nasaapp.R;
import irolso.com.nasaapp.model.Example;
import irolso.com.nasaapp.model.Photo;
import irolso.com.nasaapp.model.RespuestaJson;

/**
 * Created by Roldan on 05/08/16.
 */
public class NasaApodAdapter extends RecyclerView.Adapter<NasaApodViewHolder> {

    private List<Photo> apods;
    private OnItemClickListener onItemClickListener;

    public NasaApodAdapter(){}
    public NasaApodAdapter(List<Photo> apods)
    {this.apods = apods;}

    @Override
    public NasaApodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NasaApodViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.nasa_apod_item,parent,false));
    }

    @Override
    public void onBindViewHolder(NasaApodViewHolder holder, int position) {

        Photo photo = apods.get(position);
       /*     Picasso.with(holder.imageNasa.getContext()).load(photo.getImgSrc()).into(holder.imageNasa);*/
        holder.imageNasa.setImageURI(photo.getImgSrc());
        holder.contentNasa2.setText(photo.getRover().getName());
        holder.contentNasa.setText(photo.getEarthDate());
        holder.titleNasa.setText(photo.getCamera().getFullName());
        holder.setItemCLick(photo,onItemClickListener);
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setApods(List<Photo> apods) {
        this.apods = apods;
    }


    @Override
    public int getItemCount() {
        return apods !=null ? apods.size():0;
    }

    public interface OnItemClickListener{
        void onItemCLick(Photo photo);
    }
}
