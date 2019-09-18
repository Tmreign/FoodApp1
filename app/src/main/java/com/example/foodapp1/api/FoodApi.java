package com.example.foodapp1.api;

import com.example.foodapp1.model.Categories;
import com.example.foodapp1.model.Meals;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FoodApi {
    @GET("latest.php")
    Call<Meals> getMeal();



    @GET("categories.php")
    Call<Categories> getCategories();

}
