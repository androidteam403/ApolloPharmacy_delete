package com.example.apollopharmacy.listeners;

import com.example.apollopharmacy.model.ProductDescModelClassResponse;
import com.example.apollopharmacy.model.ShopByCategoryResponse;
import com.example.apollopharmacy.model.WhatsNewModelClass;

import java.util.List;

public interface ShopByCategoryInterface {

    void onSuccessShopByCategory(List<ShopByCategoryResponse> shopByCategoryResponse);
    void onFailureShopByCategory();

    void onSuccessWhatsNew(List<WhatsNewModelClass.Recently> whatsNewModelClasses);
    void onFailureWhatsNew();
}
