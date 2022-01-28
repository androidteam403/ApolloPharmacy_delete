package com.example.apollopharmacy.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class ShopByCategoryResponse implements Serializable
    {

        @SerializedName("category_id")
        @Expose
        private String categoryId;
        @SerializedName("url_key")
        @Expose
        private String urlKey;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("icon_url")
        @Expose
        private String iconUrl;
        @SerializedName("image_url")
        @Expose
        private String imageUrl;
        @SerializedName("description")
        @Expose
        private Object description;
        @SerializedName("product_count")
        @Expose
        private Integer productCount;
        @SerializedName("Child")
        @Expose
        private List<Child> child = null;
        private final static long serialVersionUID = 2474988160645302624L;

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getUrlKey() {
            return urlKey;
        }

        public void setUrlKey(String urlKey) {
            this.urlKey = urlKey;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public Integer getProductCount() {
            return productCount;
        }

        public void setProductCount(Integer productCount) {
            this.productCount = productCount;
        }

        public List<Child> getChild() {
            return child;
        }

        public void setChild(List<Child> child) {
            this.child = child;
        }

        public class Child implements Serializable
        {

            @SerializedName("category_id")
            @Expose
            private String categoryId;
            @SerializedName("url_key")
            @Expose
            private String urlKey;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("product_count")
            @Expose
            private Integer productCount;
            @SerializedName("Child")
            @Expose
            private List<Child__1> child = null;
            private final static long serialVersionUID = -4596962875178384838L;

            public String getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(String categoryId) {
                this.categoryId = categoryId;
            }

            public String getUrlKey() {
                return urlKey;
            }

            public void setUrlKey(String urlKey) {
                this.urlKey = urlKey;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Integer getProductCount() {
                return productCount;
            }

            public void setProductCount(Integer productCount) {
                this.productCount = productCount;
            }

            public List<Child__1> getChild() {
                return child;
            }

            public void setChild(List<Child__1> child) {
                this.child = child;
            }

            public class Child__1 implements Serializable
            {

                @SerializedName("category_id")
                @Expose
                private String categoryId;
                @SerializedName("url_key")
                @Expose
                private String urlKey;
                @SerializedName("title")
                @Expose
                private String title;
                @SerializedName("product_count")
                @Expose
                private Integer productCount;
                private final static long serialVersionUID = -427795507474479847L;

                public String getCategoryId() {
                    return categoryId;
                }

                public void setCategoryId(String categoryId) {
                    this.categoryId = categoryId;
                }

                public String getUrlKey() {
                    return urlKey;
                }

                public void setUrlKey(String urlKey) {
                    this.urlKey = urlKey;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public Integer getProductCount() {
                    return productCount;
                }

                public void setProductCount(Integer productCount) {
                    this.productCount = productCount;
                }

            }

        }
}
