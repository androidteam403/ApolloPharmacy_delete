package com.example.apollopharmacy;

import com.example.apollopharmacy.model.ProductDescModelClassRequest;
import com.example.apollopharmacy.model.ProductDescModelClassResponse;
import com.example.apollopharmacy.model.ShopByCategoryResponse;
import com.example.apollopharmacy.model.WhatsNewModelClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("https://jsonblob.com/api/jsonBlob/930683541680046080")
    Call<List<ShopByCategoryResponse>> doPostCategoryListResponse();

    @GET("https://jsonblob.com/api/jsonBlob/931106997882077184")
    Call<List<WhatsNewModelClass>> doListWhatsNew();

    @POST("https://apollorehab.in/rest/V1/productdetailsapi")
    Call<List<ProductDescModelClassResponse>> postCategoryResponse(@Header("authorization") String token, @Body ProductDescModelClassRequest productDescModelClassRequest);
}
