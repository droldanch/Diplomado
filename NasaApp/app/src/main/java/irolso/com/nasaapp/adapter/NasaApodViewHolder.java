package irolso.com.nasaapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import irolso.com.nasaapp.R;
import irolso.com.nasaapp.model.Photo;

/**
 * Created by Roldan on 05/08/16.
 */
public class NasaApodViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.titleNasaList)
    TextView titleNasa;
    @BindView(R.id.imageNasaList)
    SimpleDraweeView imageNasa;
    @BindView(R.id.titleNasaContent)
    TextView contentNasa;
    @BindView(R.id.titleNasaContent2)
    TextView contentNasa2;

    private NasaApodAdapter.OnItemClickListener onItemClickListener;
    private Photo photo;

    public NasaApodViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void setItemCLick(Photo photo, NasaApodAdapter.OnItemClickListener onItemClickListener){
        this.photo = photo;
        this.onItemClickListener = onItemClickListener;
    }

    @OnClick(R.id.imageNasaList)
    public void onViewClick(View view){
       if(onItemClickListener!=null)
           onItemClickListener.onItemCLick(photo);
    }
}
