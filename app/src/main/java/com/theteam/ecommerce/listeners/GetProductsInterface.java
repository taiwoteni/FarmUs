package com.theteam.ecommerce.listeners;

import com.theteam.ecommerce.models.SimilarProductsModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetProductsInterface {
    @GET("api/product/get-all")
    Call<ArrayList<SimilarProductsModel>> getAllProducts();
}
