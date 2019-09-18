package com.example.foodapp1;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

import com.example.foodapp1.api.FoodApi;
import com.example.foodapp1.api.FoodClient;

public class Utils {
    public static FoodApi getApi() {
        return FoodClient.getFoodClient().create(FoodApi.class);
    }

    public static AlertDialog showDialogMessage(Context context, String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).setTitle(title).setMessage(message).show();
        if (alertDialog.isShowing()) {
            alertDialog.cancel();
        }
        return alertDialog;
    }
}
