package irolso.com.nasaapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import irolso.com.nasaapp.R;
import irolso.com.nasaapp.model.Photo;
import irolso.com.nasaapp.model.PhotoBD;

/**
 * Created by Roldan on 05/08/16.
 */
public class NasaApodAdapterDB extends RecyclerView.Adapter<NasaApodViewHolder> {

    private List<PhotoBD> apods;
    private OnItemClickListener onItemClickListener;

    public NasaApodAdapterDB(){}
    public NasaApodAdapterDB(List<PhotoBD> apods)
    {this.apods = apods;}

    @Override
    public NasaApodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NasaApodViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.nasa_apod_item,parent,false));
    }

    @Override
    public void onBindViewHolder(NasaApodViewHolder holder, int position) {

        PhotoBD photo = apods.get(position);
       /*     Picasso.with(holder.imageNasa.getContext()).load(photo.getImgSrc()).into(holder.imageNasa);*/
        holder.imageNasa.setImageURI(photo.Imagen);
        holder.contentNasa2.setText(photo.Contenido);
        holder.contentNasa.setText(photo.Fecha);
        holder.titleNasa.setText(photo.Titulo);
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setApods(List<PhotoBD> apods) {
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
