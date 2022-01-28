package com.example.apollopharmacy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.apollopharmacy.controller.ShopByCategoryWhatsNewController;
import com.example.apollopharmacy.databinding.ActivityProductsViewBinding;
import com.example.apollopharmacy.databinding.Horizantalview2Binding;
import com.example.apollopharmacy.listeners.ShopByCategoryInterface;
import com.example.apollopharmacy.model.ShopByCategoryResponse;
import com.example.apollopharmacy.model.WhatsNewModelClass;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductsView extends AppCompatActivity implements RecyclerViewClickInterface, ShopByCategoryInterface, AddtoCartInterface {


    ActivityProductsViewBinding activityProductsViewBinding;



    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //   setContentView(R.layout.activity_products_view);
        activityProductsViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_products_view);

        ShopByCategoryWhatsNewController shopByCategoryController = new ShopByCategoryWhatsNewController(this);
        shopByCategoryController.shopByCategoryApiCalling();
        shopByCategoryController.whatsNewCategoryControllerApi();




    }


    @Override
    public void onSuccessShopByCategory(List<ShopByCategoryResponse> shopByCategoryResponse) {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        HorizantalAdapter adapter = new HorizantalAdapter(this, shopByCategoryResponse);
        recyclerView.setLayoutManager(new LinearLayoutManager(ProductsView.this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onFailureShopByCategory() {

    }

    @Override
    public void onSuccessWhatsNew(List<WhatsNewModelClass.Recently> whatsNewModelClasses) {
        RecyclerView whatsNewrecyclerView = (RecyclerView) findViewById(R.id.whats_new_recyclerView);
        HorizantalAdapter2 horizantalAdapter2 = new HorizantalAdapter2(this, whatsNewModelClasses, this, this);
        whatsNewrecyclerView.setLayoutManager(new LinearLayoutManager(ProductsView.this, LinearLayoutManager.HORIZONTAL, false));
        whatsNewrecyclerView.setAdapter(horizantalAdapter2);
    }

    @Override
    public void onFailureWhatsNew() {

    }

    List<WhatsNewModelClass.Recently> myListData = new ArrayList<>();


    @Override
    public void addToCartItem(WhatsNewModelClass.Recently whatsNewModelClass) {

        if(whatsNewModelClass.getQuantity()==0){
            for (int i = 0; i < myListData.size(); i++){
                if (myListData.get(i).getProductid().equals(whatsNewModelClass.getProductid())){
                  myListData.remove(myListData.get(i));
                }
            }
        }

        if (myListData != null && myListData.size() > 0) {
            boolean isCarted = false;
            int position = -1;
            for (int i = 0; i < myListData.size(); i++) {
                if (myListData.get(i).getProductid().equals(whatsNewModelClass.getProductid())) {
                    isCarted = true;
                    position = i;
                }
            }
            if (isCarted) {
                WhatsNewModelClass.Recently recently = new WhatsNewModelClass.Recently();
                recently.setName(whatsNewModelClass.getName());
                recently.setImage(String.valueOf(((whatsNewModelClass.getImage()))));
                recently.setQuantity(whatsNewModelClass.getQuantity());
                recently.setPrice(whatsNewModelClass.getPrice());
                recently.setTotal(whatsNewModelClass.getTotal());
                recently.setProductid(whatsNewModelClass.getProductid());
                recently.setSku(whatsNewModelClass.getSku());
                myListData.set(position, recently);
            } else {
                WhatsNewModelClass.Recently recently = new WhatsNewModelClass.Recently();
                recently.setName(whatsNewModelClass.getName());
                recently.setImage(String.valueOf(((whatsNewModelClass.getImage()))));
                recently.setQuantity(whatsNewModelClass.getQuantity());
                recently.setPrice(whatsNewModelClass.getPrice());
                recently.setTotal(whatsNewModelClass.getTotal());
                recently.setProductid(whatsNewModelClass.getProductid());
                recently.setSku(whatsNewModelClass.getSku());
                myListData.add(recently);
            }
        } else if(whatsNewModelClass!=null&&whatsNewModelClass.getQuantity()>0){
            WhatsNewModelClass.Recently recently = new WhatsNewModelClass.Recently();
            recently.setName(whatsNewModelClass.getName());
            recently.setImage(String.valueOf(((whatsNewModelClass.getImage()))));
            recently.setQuantity(whatsNewModelClass.getQuantity());
            recently.setPrice(whatsNewModelClass.getPrice());
            recently.setTotal(whatsNewModelClass.getTotal());
            recently.setProductid(whatsNewModelClass.getProductid());
            recently.setSku(whatsNewModelClass.getSku());
            myListData.add(recently);
        }
        activityProductsViewBinding.hearLayout.cartzero.setText(String.valueOf(myListData.size()));

    }


    @Override
    public void onItemClicked(String sku) {
        Intent i = new Intent(ProductsView.this, ProductDrescription.class);
        i.putExtra("myListData", (Serializable) myListData);
        i.putExtra("productId",sku);
        startActivityForResult(i, 888);
    }
}

