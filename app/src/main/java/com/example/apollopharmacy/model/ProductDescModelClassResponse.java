package com.example.apollopharmacy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class ProductDescModelClassResponse implements Serializable
{

    @SerializedName("productdp")
    @Expose
    private Productdp productdp;
    private final static long serialVersionUID = -5542809286116852806L;

    public Productdp getProductdp() {
        return productdp;
    }

    public void setProductdp(Productdp productdp) {
        this.productdp = productdp;
    }

    public static class Productdp implements Serializable
    {

        @SerializedName("productid")
        @Expose
        private Integer productid;
        @SerializedName("producttype")
        @Expose
        private String producttype;
        @SerializedName("sku")
        @Expose
        private String sku;
        @SerializedName("price")
        @Expose
        private Integer price;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("url_key")
        @Expose
        private String urlKey;
        @SerializedName("brand")
        @Expose
        private String brand;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("productgallary")
        @Expose
        private List<String> productgallary = null;
        @SerializedName("thumbnail")
        @Expose
        private String thumbnail;
        @SerializedName("small_image")
        @Expose
        private String smallImage;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("stock")
        @Expose
        private Boolean stock;
        @SerializedName("qty")
        @Expose
        private Integer qty;
        @SerializedName("Assured")
        @Expose
        private String assured;
        @SerializedName("Attr360View")
        @Expose
        private String attr360View;
        @SerializedName("view_link")
        @Expose
        private String viewLink;
        @SerializedName("discount")
        @Expose
        private Integer discount;
        @SerializedName("offer")
        @Expose
        private Integer offer;
        @SerializedName("categoryIds")
        @Expose
        private List<String> categoryIds = null;
        @SerializedName("is_salable")
        @Expose
        private Boolean isSalable;
        @SerializedName("features")
        @Expose
        private String features;
        @SerializedName("warranty")
        @Expose
        private Object warranty;
        @SerializedName("Material")
        @Expose
        private Object material;
        @SerializedName("returnpolicy")
        @Expose
        private String returnpolicy;
        @SerializedName("countryoforigin")
        @Expose
        private String countryoforigin;
        @SerializedName("manufacturer")
        @Expose
        private String manufacturer;
        private final static long serialVersionUID = -3635141460003904092L;

        public Integer getProductid() {
            return productid;
        }

        public void setProductid(Integer productid) {
            this.productid = productid;
        }

        public String getProducttype() {
            return producttype;
        }

        public void setProducttype(String producttype) {
            this.producttype = producttype;
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUrlKey() {
            return urlKey;
        }

        public void setUrlKey(String urlKey) {
            this.urlKey = urlKey;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public List<String> getProductgallary() {
            return productgallary;
        }

        public void setProductgallary(List<String> productgallary) {
            this.productgallary = productgallary;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getSmallImage() {
            return smallImage;
        }

        public void setSmallImage(String smallImage) {
            this.smallImage = smallImage;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Boolean getStock() {
            return stock;
        }

        public void setStock(Boolean stock) {
            this.stock = stock;
        }

        public Integer getQty() {
            return qty;
        }

        public void setQty(Integer qty) {
            this.qty = qty;
        }

        public String getAssured() {
            return assured;
        }

        public void setAssured(String assured) {
            this.assured = assured;
        }

        public String getAttr360View() {
            return attr360View;
        }

        public void setAttr360View(String attr360View) {
            this.attr360View = attr360View;
        }

        public String getViewLink() {
            return viewLink;
        }

        public void setViewLink(String viewLink) {
            this.viewLink = viewLink;
        }

        public Integer getDiscount() {
            return discount;
        }

        public void setDiscount(Integer discount) {
            this.discount = discount;
        }

        public Integer getOffer() {
            return offer;
        }

        public void setOffer(Integer offer) {
            this.offer = offer;
        }

        public List<String> getCategoryIds() {
            return categoryIds;
        }

        public void setCategoryIds(List<String> categoryIds) {
            this.categoryIds = categoryIds;
        }

        public Boolean getIsSalable() {
            return isSalable;
        }

        public void setIsSalable(Boolean isSalable) {
            this.isSalable = isSalable;
        }

        public String getFeatures() {
            return features;
        }

        public void setFeatures(String features) {
            this.features = features;
        }

        public Object getWarranty() {
            return warranty;
        }

        public void setWarranty(Object warranty) {
            this.warranty = warranty;
        }

        public Object getMaterial() {
            return material;
        }

        public void setMaterial(Object material) {
            this.material = material;
        }

        public String getReturnpolicy() {
            return returnpolicy;
        }

        public void setReturnpolicy(String returnpolicy) {
            this.returnpolicy = returnpolicy;
        }

        public String getCountryoforigin() {
            return countryoforigin;
        }

        public void setCountryoforigin(String countryoforigin) {
            this.countryoforigin = countryoforigin;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

    }

}
