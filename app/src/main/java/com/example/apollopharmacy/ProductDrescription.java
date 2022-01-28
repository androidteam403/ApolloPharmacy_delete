package com.example.apollopharmacy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.apollopharmacy.controller.ProductDescriptionController;
import com.example.apollopharmacy.databinding.ActivityProductDrescriptionBinding;
import com.example.apollopharmacy.listeners.ProductDescriptionInterface;
import com.example.apollopharmacy.model.ProductDescModelClassResponse;
import com.example.apollopharmacy.model.WhatsNewModelClass;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class ProductDrescription extends AppCompatActivity implements ProductDescriptionInterface {

    ActivityProductDrescriptionBinding binding;
    String sku;
    ProductDescModelClassResponse.Productdp productDescModelClassResponse;

    @SuppressLint("ResourceType")
    private List<WhatsNewModelClass.Recently> myListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_drescription);

        if (getIntent()!=null){
             myListData=(List<WhatsNewModelClass.Recently>) getIntent().getSerializableExtra("myListData");
             sku=(String) getIntent().getStringExtra("productId");
        }
        ProductDescriptionController productDescriptionController = new ProductDescriptionController(this);
        productDescriptionController.productDescApiCall(sku);

        binding.addtocart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.addtocart1.setVisibility(View.GONE);
                binding.addingtocart.setVisibility(View.VISIBLE);
                productDescModelClassResponse.setQty(Integer.valueOf(binding.numberofitems.getText().toString()));
                addToCart();
            }
            });
        binding.increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i= Integer.parseInt(binding.numberofitems.getText().toString());
                i++;
                binding.numberofitems.setText(String.valueOf(i));
//                for(int j=0; j<myListData.size(); j++){
                productDescModelClassResponse.setQty(Integer.parseInt(binding.numberofitems.getText().toString()));
                addToCart();
}
        });

        binding.decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(binding.numberofitems.getText().toString())==1){
                    binding.addtocart1.setVisibility(View.VISIBLE);
                    binding.addingtocart.setVisibility(View.GONE);
                    productDescModelClassResponse.setQty(0);
                    addToCart();
                } else if(Integer.parseInt(binding.numberofitems.getText().toString())>1) {
                    int i= Integer.parseInt(binding.numberofitems.getText().toString());
                    i--;
                    binding.numberofitems.setText(String.valueOf(i));
                    productDescModelClassResponse.setQty(Integer.parseInt(binding.numberofitems.getText().toString()));
                    addToCart();
//                    myListData.setQuantity(Integer.parseInt(holder.binding.numberofitems.getText().toString()));
                }

            }});

        binding.hearLayout.addcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.descriptionwindow.setVisibility(View.GONE);
                RelativeLayout itemInCart=findViewById(R.id.item_in_cart);
                binding.addtocartlay.itemInCart.setVisibility(View.VISIBLE);

            }
        });

        binding.addtocartlay.continuebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProductDrescription.this, UserAddressActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onSucessProductDesc(ProductDescModelClassResponse.Productdp productDescModelClassResponse) {
        this.productDescModelClassResponse=productDescModelClassResponse;
        binding.productNamee.setText(productDescModelClassResponse.getName());
        binding.price.setText("₹" + String.valueOf(productDescModelClassResponse.getPrice()));
        binding.productDescription.setText(productDescModelClassResponse.getDescription());
        Picasso.with(this).load(Uri.parse(String.valueOf(productDescModelClassResponse.getImage()))).into(binding.productimage);
        
        binding.threesixty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.with(getApplicationContext()).load(Uri.parse(String.valueOf(productDescModelClassResponse.getAttr360View()))).into(binding.threesixty);
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerviewdescription);
        DescriptionAdapter adapter = new DescriptionAdapter(productDescModelClassResponse.getProductgallary(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    private void addToCart(){
        if (myListData != null && myListData.size() > 0) {
            boolean isCarted = false;
            int position = -1;
            for (int i = 0; i < myListData.size(); i++) {
                if (myListData.get(i).getSku().equals(productDescModelClassResponse.getSku())) {
//                    myListData.get(i).setQuantity(Integer.parseInt(binding.numberofitems.getText().toString()));
                    isCarted = true;
                    position = i;

                    if(myListData!=null&&myListData.get(i).getQuantity()==1  && productDescModelClassResponse.getQty()==0){
//                       for (i = 0; i < myListData.size(); i++){
//                            if (myListData.get(i).getSku().equals(productDescModelClassResponse.getSku())){
                                myListData.remove(myListData.get(i));
//                            }
//                        }
                    }

                }
                if(myListData!=null&&myListData.size()>0&&myListData.get(i).getQuantity()>1 && productDescModelClassResponse.getQty()==0){
                    WhatsNewModelClass.Recently recently = new WhatsNewModelClass.Recently();
                    recently.setName(productDescModelClassResponse.getName());
                    recently.setImage(String.valueOf(((productDescModelClassResponse.getImage()))));
                    recently.setQuantity(myListData.get(position).getQuantity()-1);
                    recently.setPrice(productDescModelClassResponse.getPrice());
                    recently.setProductid(productDescModelClassResponse.getProductid());
                    recently.setSku(productDescModelClassResponse.getSku());
                    myListData.set(position, recently);
                }
            }
            if (myListData!=null&&myListData.size()>0) {
                if (isCarted) {
                    WhatsNewModelClass.Recently recently = new WhatsNewModelClass.Recently();
                    recently.setName(productDescModelClassResponse.getName());
                    recently.setImage(String.valueOf(((productDescModelClassResponse.getImage()))));
                    recently.setQuantity(productDescModelClassResponse.getQty());
                    recently.setPrice(productDescModelClassResponse.getPrice());
                    recently.setProductid(productDescModelClassResponse.getProductid());
                    recently.setSku(productDescModelClassResponse.getSku());
                    myListData.set(position, recently);
                } else {
                    WhatsNewModelClass.Recently recently = new WhatsNewModelClass.Recently();
                    recently.setName(productDescModelClassResponse.getName());
                    recently.setImage(String.valueOf(((productDescModelClassResponse.getImage()))));
                    recently.setQuantity(productDescModelClassResponse.getQty());
                    recently.setPrice(productDescModelClassResponse.getPrice());
                    recently.setProductid(productDescModelClassResponse.getProductid());
                    recently.setSku(productDescModelClassResponse.getSku());
                    myListData.add(recently);
                }
            }
        }
        else {
            WhatsNewModelClass.Recently recently = new WhatsNewModelClass.Recently();
            recently.setName(productDescModelClassResponse.getName());
            recently.setImage(String.valueOf(((productDescModelClassResponse.getImage()))));
            recently.setQuantity(productDescModelClassResponse.getQty());
            recently.setPrice(productDescModelClassResponse.getPrice());
            recently.setProductid(productDescModelClassResponse.getProductid());
            recently.setSku(productDescModelClassResponse.getSku());
            myListData.add(recently);
        }


        binding.hearLayout.cartzero.setText(String.valueOf(myListData.size()));

        RecyclerView recyclerView1 = (RecyclerView) findViewById(R.id.itemincartrecycler);
        ItemCartAdapter adapter4 = new ItemCartAdapter(myListData);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setAdapter(adapter4);

    }



    @Override
    public void onFailureProductDesc() {

    }
}
