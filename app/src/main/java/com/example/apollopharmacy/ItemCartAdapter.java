package com.example.apollopharmacy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apollopharmacy.model.ProductDescModelClassResponse;
import com.example.apollopharmacy.model.WhatsNewModelClass;

import org.w3c.dom.Text;

import java.util.List;

public class ItemCartAdapter extends RecyclerView.Adapter<ItemCartAdapter.ItemCartViewAdapter> {

//    private List<ProductDescModelClassResponse> listData;

    Double price;
    Integer quantity;
    Double total;

    List<WhatsNewModelClass.Recently> myListData;

    public ItemCartAdapter(List<WhatsNewModelClass.Recently> myListData) {
        this.myListData = myListData;
    }

    @NonNull
    @Override
    public ItemCartAdapter.ItemCartViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.itemsinyourcartrecyclerview, parent, false);
         ItemCartViewAdapter itemCartViewAdapter = new ItemCartViewAdapter(listItem);
        return itemCartViewAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemCartAdapter.ItemCartViewAdapter holder, int position) {
        final WhatsNewModelClass.Recently recently = myListData.get(position);

//        holder.img1.setImageResource(Integer.parseInt(String.valueOf(myListData.get(position).getImage())));
        holder.txt1.setText(myListData.get(position).getName());
        holder.txt2.setText(String.valueOf("₹" + myListData.get(position).getPrice()));
        holder.txt3.setText(String.valueOf( myListData.get(position).getQuantity()));
//        holder.txt4.setText(String.valueOf("₹" + myListData.get(position).getPrice()));


//        price = Double.parseDouble(String.valueOf(holder.txt2));
//        quantity = Integer.parseInt(String.valueOf((holder.txt2)));
//        total = price * quantity;
//
//        holder.txt4.setText(Double.toString(total));



    }

    @Override
    public int getItemCount() {
        return myListData.size();
    }

    public class ItemCartViewAdapter extends RecyclerView.ViewHolder{
        public ImageView img1;
        public TextView txt1;
        public TextView txt2;
        public  TextView txt3;
        public TextView txt4;
        public  ImageView img2;
        public ItemCartViewAdapter(@NonNull View itemView) {
            super(itemView);

            img1 = itemView.findViewById(R.id.productimag);
            txt1 = itemView.findViewById(R.id.name);
            txt2 = itemView.findViewById(R.id.price1);
            txt3 = itemView.findViewById(R.id.quantity1);
            txt4= itemView.findViewById(R.id.totalprice);


        }
    }
}
