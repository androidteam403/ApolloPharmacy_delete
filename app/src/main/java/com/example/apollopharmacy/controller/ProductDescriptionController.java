package com.example.apollopharmacy.controller;

import androidx.annotation.NonNull;

import com.example.apollopharmacy.ApiClient;
import com.example.apollopharmacy.ApiInterface;
import com.example.apollopharmacy.listeners.ProductDescriptionInterface;
import com.example.apollopharmacy.model.ProductDescModelClassRequest;
import com.example.apollopharmacy.model.ProductDescModelClassResponse;
import com.example.apollopharmacy.model.ShopByCategoryResponse;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDescriptionController {

    ProductDescriptionInterface productDescriptionInterface;

    public ProductDescriptionController(ProductDescriptionInterface productDescriptionInterface) {
        this.productDescriptionInterface = productDescriptionInterface;
    }

    public void productDescApiCall(String sku){
        ApiInterface apiInterface= ApiClient.getApiService();
        ProductDescModelClassRequest productDescModelClassRequest=new ProductDescModelClassRequest();
        productDescModelClassRequest.setParams(sku);
        Call<List<ProductDescModelClassResponse>> call = apiInterface.postCategoryResponse("Bearer p8g0s5tcwz1qnqibpszco93rp36ec7mk",productDescModelClassRequest);
        call.enqueue(new Callback<List<ProductDescModelClassResponse>>() {
            @Override
            public void onResponse(Call<List<ProductDescModelClassResponse>> call, Response<List<ProductDescModelClassResponse>> response) {
                if (response.body()!=null){
                    productDescriptionInterface.onSucessProductDesc(response.body().get(0).getProductdp());
                }
            }
            @Override
            public void onFailure(@NonNull Call<List<ProductDescModelClassResponse>> call, @NonNull Throwable t) {
                productDescriptionInterface.onFailureProductDesc();
            }
        });
    }
}
