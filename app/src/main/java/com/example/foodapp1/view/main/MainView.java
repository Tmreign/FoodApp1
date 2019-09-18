package com.example.foodapp1.view.main;

import com.example.foodapp1.model.Categories;
import com.example.foodapp1.model.Meals;

import java.util.List;

public interface MainView {

    void showloading();
    void hideLoading();
    void setMeal(List<Meals.Meal> meal);
    void setCategory(List<Categories.Category> category);
    void onErrorLoading(String message);
}
