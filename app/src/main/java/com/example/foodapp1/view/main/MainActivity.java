package com.example.foodapp1.view.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.foodapp1.R;
import com.example.foodapp1.Utils;
import com.example.foodapp1.adapter.RecyclerViewMainAdapter;
import com.example.foodapp1.adapter.ViewPagerHeaderAdapter;
import com.example.foodapp1.model.Categories;
import com.example.foodapp1.model.Meals;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView  {

    @BindView(R.id.viewPagerHeader)
    ViewPager viewPagerMeal;
    @BindView(R.id.recyclerCategory)
    RecyclerView recyclerViewCategory;

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenter(this);
        presenter.getMeals();
        presenter.getCategories();
    }

    @Override
    public void showloading() {
        findViewById(R.id.shimmerMeal).setVisibility(View.VISIBLE);
        findViewById(R.id.shimmerCategory).setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoading() {
        findViewById(R.id.shimmerMeal).setVisibility(View.GONE);
        findViewById(R.id.shimmerCategory).setVisibility(View.GONE);

    }

    @Override
    public void setMeal(List<Meals.Meal> meal) {
        ViewPagerHeaderAdapter headerAdapter = new ViewPagerHeaderAdapter(meal,this);
        viewPagerMeal.setAdapter(headerAdapter);
        viewPagerMeal.setPadding(20,0,150,0);
        headerAdapter.notifyDataSetChanged();

        headerAdapter.setOnItemClickListener((v, position) -> {
            Toast.makeText(this, meal.get(position).getStrMeal(), Toast.LENGTH_SHORT).show();

        });

    }

    @Override
    public void setCategory(List<Categories.Category> category) {
        RecyclerViewMainAdapter mainAdapter = new RecyclerViewMainAdapter(category,this);
        recyclerViewCategory.setAdapter(mainAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3, GridLayoutManager.VERTICAL,false);
        recyclerViewCategory.setLayoutManager(layoutManager);
        recyclerViewCategory.setNestedScrollingEnabled(true);
        mainAdapter.notifyDataSetChanged();


        mainAdapter.setOnItemClickListener((view, position) -> {
            Toast.makeText(this, category.get(position).getStrCategory(), Toast.LENGTH_SHORT).show();

        });
    }

    @Override
    public void onErrorLoading(String message) {
        Utils.showDialogMessage(this,"Title",message);


    }

}
