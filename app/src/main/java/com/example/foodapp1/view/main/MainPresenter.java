package com.example.foodapp1.view.main;

import androidx.annotation.NonNull;

import com.example.foodapp1.Utils;
import com.example.foodapp1.model.Categories;
import com.example.foodapp1.model.Meals;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {

    private  MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    void getMeals() {

        view.showloading();


        Call<Meals> mealsCall = Utils.getApi().getMeal();


        mealsCall.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(@NonNull Call<Meals> call, @NonNull Response<Meals> response) {

                view.hideLoading();

                if (response.isSuccessful() && response.body() != null) {

                    view.setMeal(response.body().getMeals());
                }
                else {

                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(Call<Meals> call, Throwable t) {

                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage() );

            }
        });
    }


    void getCategories() {

        view.showloading();

        Call<Categories> categoriesCall = Utils.getApi().getCategories();


        categoriesCall.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(@NonNull Call<Categories> call,@NonNull Response<Categories> response) {


                if (response.isSuccessful() && response.body() != null) {


                    view.setCategory(response.body().getCategories());
                }
                else {

                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Categories> call,@NonNull  Throwable t) {


                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage() );
            }
        });
    }
}
