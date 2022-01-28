package com.example.apollopharmacy;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apollopharmacy.databinding.Horizantalview2Binding;
import com.example.apollopharmacy.model.WhatsNewModelClass;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HorizantalAdapter2 extends RecyclerView.Adapter<HorizantalAdapter2.HorizantalViewAdapter>
{
    private Activity activity;
    private List<WhatsNewModelClass.Recently> listData2;
    AddtoCartInterface addtoCartInterface;
    RecyclerViewClickInterface recyclerViewClickInterface;
    int quantity;

//    List<ItemCartModelClass> myData = new ArrayList<>();


    public HorizantalAdapter2(Activity activity, List<WhatsNewModelClass.Recently> listdata2, AddtoCartInterface addtoCartInterface,RecyclerViewClickInterface recyclerViewClickInterface) {
        this.listData2 = listdata2;
        this.activity = activity;
        this.addtoCartInterface = addtoCartInterface;
        this.recyclerViewClickInterface = recyclerViewClickInterface;
    }

    @NonNull
    @Override
    public HorizantalViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        Horizantalview2Binding binding= DataBindingUtil.inflate(layoutInflater, R.layout.horizantalview2, parent, false);
         HorizantalViewAdapter viewHolder = new HorizantalViewAdapter(binding);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull HorizantalViewAdapter holder, @SuppressLint("RecyclerView") int position) {
        final WhatsNewModelClass.Recently myListData = listData2.get(position);
        holder.binding.cost3.setText(String.valueOf("₹" + listData2.get(position).getPrice()));
        Picasso.with(activity).load(Uri.parse(String.valueOf(myListData.getImage()))).error(activity.getResources().getDrawable(R.drawable.mobility_aids)).into(holder.binding.image2);
        holder.binding.name2.setText(listData2.get(position).getName());

        holder.binding.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                recyclerViewClickInterface.onItemClicked(myListData.getSku());

            }
        });

        holder.binding.addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.binding.basket.setVisibility(View.GONE);
                holder.binding.addingtocart.setVisibility(View.VISIBLE);
//                holder.binding.numberofitems.setText("1");
                myListData.setQuantity(Integer.parseInt(holder.binding.numberofitems.getText().toString()));
                addtoCartInterface.addToCartItem(myListData);
            }
        });

        holder.binding.increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i= Integer.parseInt(holder.binding.numberofitems.getText().toString());
                i++;
                holder.binding.numberofitems.setText(String.valueOf(i));
                myListData.setQuantity(Integer.parseInt(holder.binding.numberofitems.getText().toString()));
                addtoCartInterface.addToCartItem(myListData);

            }
        });

        holder.binding.decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(holder.binding.numberofitems.getText().toString())==1){
                            holder.binding.basket.setVisibility(View.VISIBLE);
                            holder.binding.addingtocart.setVisibility(View.GONE);
                    myListData.setQuantity(0);
                    addtoCartInterface.addToCartItem(myListData);

                }
                else if(Integer.parseInt(holder.binding.numberofitems.getText().toString())>1) {
                    int i= Integer.parseInt(holder.binding.numberofitems.getText().toString());
                    i--;
                    holder.binding.numberofitems.setText(String.valueOf(i));
                    myListData.setQuantity(Integer.parseInt(holder.binding.numberofitems.getText().toString()));
                    addtoCartInterface.addToCartItem(myListData);

                }

            }});

    }

    @Override
    public int getItemCount() {
        return listData2.size();
    }


    public class HorizantalViewAdapter extends RecyclerView.ViewHolder{
         Horizantalview2Binding binding;
        public HorizantalViewAdapter(@NonNull  Horizantalview2Binding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
    }

