package com.example.apollopharmacy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apollopharmacy.databinding.UseraddressactivitysummaryrecyclerviewBinding;

import java.util.List;

public class UserAddressAdapter extends RecyclerView.Adapter<UserAddressAdapter.UserAddressViewAdapter> {

    public UserAddressAdapter(List<SummaryModelClass> listdata) {
        this.listdata = listdata;
    }

    private List<SummaryModelClass> listdata;


    @NonNull
    @Override
    public UserAddressViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.useraddressactivitysummaryrecyclerview, parent, false);
        UserAddressViewAdapter viewHolder = new UserAddressViewAdapter(listItem);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull UserAddressViewAdapter holder, int position) {

        final SummaryModelClass myListData = listdata.get(position);

        holder.img2.setImageResource(myListData.getImg());
        holder.tx1.setText(listdata.get(position).getProductName());;
        holder.tx2.setText("₹" +String.valueOf(listdata.get(position).getPrice()));
        holder.tx3.setText(String.valueOf(listdata.get(position).getQuantity()));
        holder.tx4.setText("₹"+String.valueOf(listdata.get(position).getTotalPrice()));



    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class UserAddressViewAdapter extends RecyclerView.ViewHolder {
        public ImageView img2;
        public TextView tx1;
        public TextView tx2;
        public  TextView tx3;
        public  TextView tx4;
        public UserAddressViewAdapter(@NonNull View itemView) {

            super(itemView);
            img2 = itemView.findViewById(R.id.imgforsummary5);
            tx1 = itemView.findViewById(R.id.adrsproductname);
            tx2 = itemView.findViewById(R.id.adrsprice);
            tx3 = itemView.findViewById(R.id.adrsquantity);
            tx4= itemView.findViewById(R.id.adrstotalprice);

        }
    }
}
