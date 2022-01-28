package com.example.apollopharmacy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.apollopharmacy.databinding.ActivityUserAddressBinding;
import com.example.apollopharmacy.databinding.Canceldialoguebox2Binding;
import com.example.apollopharmacy.databinding.PhonepedialogueBinding;

import java.util.ArrayList;
import java.util.List;


public class UserAddressActivity extends AppCompatActivity {
  ActivityUserAddressBinding binding;
    Dialog dialog2;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user_address);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_address);

        List<SummaryModelClass> newList = new ArrayList<>();

        SummaryModelClass myDataList=new SummaryModelClass(R.drawable.apolloash, "B.P MONITOR HEM", 10980, 1, 10980 );
        newList.add(myDataList);
        myDataList=new SummaryModelClass(R.drawable.independent_living_aids, "PHYSIO BAND LATEX FREE", 775, 1, 775 );
        newList.add(myDataList);
        myDataList=new SummaryModelClass(R.drawable.apolloash, "OMRON NERVE STIMULATOR", 990, 1, 990 );
        newList.add(myDataList);

        RecyclerView recyclerView5 = (RecyclerView) findViewById(R.id.recyclerviewforsummary);
        UserAddressAdapter adapter3 = new UserAddressAdapter(newList);
        recyclerView5.setLayoutManager(new LinearLayoutManager(UserAddressActivity.this, LinearLayoutManager.VERTICAL, false));
        recyclerView5.setAdapter(adapter3);


         dialog=new Dialog(this);
         PhonepedialogueBinding phonepedialogueBinding = DataBindingUtil.inflate(LayoutInflater.from(this),R.layout.phonepedialogue, null,false);
        dialog = new Dialog(this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.setContentView(phonepedialogueBinding.getRoot());
        if (dialog.getWindow() != null)
            dialog.getWindow().setBackgroundDrawableResource(R.color.transperantblack);



        binding.onlinePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                    }
                });


        dialog2=new Dialog(this);
        Canceldialoguebox2Binding binding2 = DataBindingUtil.inflate(LayoutInflater.from(this),R.layout.canceldialoguebox2, null,false);
        dialog2 = new Dialog(this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog2.setContentView(binding2.getRoot());
        if (dialog2.getWindow() != null)
            dialog2.getWindow().setBackgroundDrawableResource(R.color.transperantblack);

        phonepedialogueBinding.cancelbuttonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.show();

                binding2.yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog2.dismiss();
                        dialog.dismiss();
                    }
                });

                binding2.no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog2.dismiss();
                    }
                });

            }});


        binding.placeorderbutton.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
               Intent i = new Intent(UserAddressActivity.this, FinalSummaryScreen.class);
               startActivity(i);
            }
      });



}

}