package com.example.apollopharmacy.listeners;

import com.example.apollopharmacy.model.ProductDescModelClassResponse;

import java.util.List;

import retrofit2.Callback;

public interface ProductDescriptionInterface {
    void onSucessProductDesc(ProductDescModelClassResponse.Productdp productdp);
    void onFailureProductDesc();
}
