package com.example.apollopharmacy;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apollopharmacy.model.ShopByCategoryResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HorizantalAdapter extends RecyclerView.Adapter<HorizantalAdapter.HorizantalViewAdapter>
{
    private List<ShopByCategoryResponse> listdata;
    private Activity activity;


    public HorizantalAdapter(Activity activity,List<ShopByCategoryResponse> listdata) {
        this.listdata = listdata;
        this.activity=activity;
    }

    @NonNull
    @Override
    public HorizantalViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.horizantalview, parent, false);
        HorizantalViewAdapter viewHolder = new HorizantalViewAdapter(listItem);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull HorizantalViewAdapter holder, @SuppressLint("RecyclerView") int position) {
        final ShopByCategoryResponse myListData = listdata.get(position);
        holder.txt.setText(String.valueOf(myListData.getChild().size()));
//         holder.img.setImageResource(myListData.getImage());
        Picasso.with(activity).load(Uri.parse(String.valueOf(myListData.getImageUrl()))).error(activity.getResources().getDrawable(R.drawable.mobility_aids)).into(holder.img);

        holder.desc.setText(listdata.get(position).getTitle());



    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class HorizantalViewAdapter extends RecyclerView.ViewHolder{
            TextView txt;
            ImageView img;
            TextView desc;
            public RelativeLayout relativeLayout;
        public HorizantalViewAdapter(@NonNull View itemView) {
            super(itemView);

            txt = itemView.findViewById(R.id.yellow);
            img = itemView.findViewById(R.id.image);
            desc = itemView.findViewById(R.id.name);
            relativeLayout = itemView.findViewById(R.id.main_container);
        }
    }
}
