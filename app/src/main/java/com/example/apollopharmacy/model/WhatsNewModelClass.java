package com.example.apollopharmacy.model;
import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class WhatsNewModelClass implements Serializable
    {

        @SerializedName("recently")
        @Expose
        private List<Recently> recently = null;

        public List<Recently> getRecently() {
            return recently;
        }

        public void setRecently(List<Recently> recently) {
            this.recently = recently;
        }

        public static class Recently implements Serializable {

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
            @SerializedName("discount")
            @Expose
            private Integer discount;
            @SerializedName("offerprice")
            @Expose
            private double offerprice;
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
            @SerializedName("stock")
            @Expose
            private Integer stock;
            @SerializedName("Assured")
            @Expose
            private String assured;
            @SerializedName("Attr360View")
            @Expose
            private String attr360View;
            @SerializedName("view_link")
            @Expose
            private String viewLink;
            @SerializedName("image")
            @Expose
            private String image;
            @SerializedName("thumbnail")
            @Expose
            private String thumbnail;
            @SerializedName("small_image")
            @Expose
            private String smallImage;
            @SerializedName("manufacturer")
            @Expose
            private Boolean manufacturer;
            @SerializedName("description")
            @Expose
            private Object description;
            @SerializedName("categoryIds")
            @Expose
            private List<String> categoryIds = null;
            @SerializedName("is_salable")
            @Expose
            private Boolean isSalable;

            private Boolean isBrandItemChecked = false;

            public Boolean getBrandItemChecked() {
                return isBrandItemChecked;
            }

            public void setBrandItemChecked(Boolean brandItemChecked) {
                isBrandItemChecked = brandItemChecked;
            }

            private boolean isZoomed;
            private boolean isZoomedCanel;
            private int quantity = 0;
            private int total = 0;
            private int grandTotal = 0;
            private boolean isSelcted = false;

            public Integer getDiscount() {
                return discount;
            }

            public void setDiscount(Integer discount) {
                this.discount = discount;
            }

            public double getOfferprice() {
                return offerprice;
            }

            public void setOfferprice(double offerprice) {
                this.offerprice = offerprice;
            }

            public Boolean getSalable() {
                return isSalable;
            }

            public void setSalable(Boolean salable) {
                isSalable = salable;
            }

            public boolean isZoomed() {
                return isZoomed;
            }

            public void setZoomed(boolean zoomed) {
                isZoomed = zoomed;
            }

            public boolean isZoomedCanel() {
                return isZoomedCanel;
            }

            public void setZoomedCanel(boolean zoomedCanel) {
                isZoomedCanel = zoomedCanel;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getGrandTotal() {
                return grandTotal;
            }

            public void setGrandTotal(int grandTotal) {
                this.grandTotal = grandTotal;
            }

            public boolean isSelcted() {
                return isSelcted;
            }

            public void setSelcted(boolean selcted) {
                isSelcted = selcted;
            }

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

            public Integer getStock() {
                return stock;
            }

            public void setStock(Integer stock) {
                this.stock = stock;
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

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
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

            public Boolean getManufacturer() {
                return manufacturer;
            }

            public void setManufacturer(Boolean manufacturer) {
                this.manufacturer = manufacturer;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
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

        }


}