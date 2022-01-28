package com.example.apollopharmacy;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apollopharmacy.model.ProductDescModelClassResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DescriptionAdapter extends RecyclerView.Adapter<DescriptionAdapter.DescriptionViewAdapter>{
    List<String> productgallery;
    ProductDrescription activity;

//    public DescriptionAdapter(List<ProductDescModelClassResponse.Productdp> productDescModelClassResponse, Activity activity) {
//        this.productDescModelClassResponse = productDescModelClassResponse;
////        this.activity = activity;


    public DescriptionAdapter(List<String> productgallary, ProductDrescription activity) {
        this.productgallery = productgallary;
        this.activity = activity;
    }

    @NonNull
    @Override
    public DescriptionViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.productdescriptionadapter, parent, false);
       DescriptionViewAdapter descriptionViewAdapter = new DescriptionViewAdapter(listItem);
        return descriptionViewAdapter;

    }

    @Override
    public void onBindViewHolder(@NonNull DescriptionViewAdapter holder, @SuppressLint("RecyclerView") int position) {
        final String myListData = productgallery.get(position);
//      holder.img.setImageResource(Integer.parseInt(String.valueOf(myListData.getProductgallary())));
        Picasso.with(activity).load(Uri.parse(String.valueOf((myListData)))).error(activity.getResources().getDrawable(R.drawable.mobility_aids)).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return productgallery.size();
    }

    public class DescriptionViewAdapter extends RecyclerView.ViewHolder{
        public ImageView img;
        public DescriptionViewAdapter(@NonNull View itemView) {
            super(itemView);

            img =  itemView.findViewById(R.id.descimg);
        }
    }
}
