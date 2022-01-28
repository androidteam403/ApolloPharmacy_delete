package com.example.apollopharmacy.controller;

import androidx.annotation.NonNull;

import com.example.apollopharmacy.ApiClient;
import com.example.apollopharmacy.ApiInterface;
import com.example.apollopharmacy.listeners.ProductDescriptionInterface;
import com.example.apollopharmacy.listeners.ShopByCategoryInterface;
import com.example.apollopharmacy.model.ProductDescModelClassRequest;
import com.example.apollopharmacy.model.ProductDescModelClassResponse;
import com.example.apollopharmacy.model.ShopByCategoryResponse;
import com.example.apollopharmacy.model.WhatsNewModelClass;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShopByCategoryWhatsNewController {

    ShopByCategoryInterface shopByCategoryInterface;



    public ShopByCategoryWhatsNewController(ShopByCategoryInterface shopByCategoryInterface) {
        this.shopByCategoryInterface = shopByCategoryInterface;

    }


    public void shopByCategoryApiCalling(){
        ApiInterface apiInterface= ApiClient.getApiService();
        Call<List<ShopByCategoryResponse>> call = apiInterface.doPostCategoryListResponse();
        call.enqueue(new Callback<List<ShopByCategoryResponse>>() {
            @Override
            public void onResponse(Call<List<ShopByCategoryResponse>> call, Response<List<ShopByCategoryResponse>> response) {
                if (response.isSuccessful()){
                    shopByCategoryInterface.onSuccessShopByCategory(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ShopByCategoryResponse>> call, @NonNull Throwable t) {
                shopByCategoryInterface.onFailureShopByCategory();
            }
        });


    }

    public void whatsNewCategoryControllerApi(){
        ApiInterface apiInterface= ApiClient.getApiService();
        Call<List<WhatsNewModelClass>> call = apiInterface.doListWhatsNew();
        call.enqueue(new Callback<List<WhatsNewModelClass>>() {
            @Override
            public void onResponse(Call<List<WhatsNewModelClass>> call, Response<List<WhatsNewModelClass>> response) {
                if (response.isSuccessful()){
                    shopByCategoryInterface.onSuccessWhatsNew(response.body().get(0).getRecently());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<WhatsNewModelClass>> call, @NonNull Throwable t) {
                shopByCategoryInterface.onFailureShopByCategory();
            }
        });
    }


}
