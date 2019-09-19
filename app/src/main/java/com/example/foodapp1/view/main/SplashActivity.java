package com.example.foodapp1.view.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodapp1.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        ImageView imageView = (ImageView)findViewById(R.id.imagerot);
        TextView textView = (TextView)findViewById(R.id.textrot);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotateanim);
        imageView.startAnimation(animation);

        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.downanim);
        textView.startAnimation(animation1 );
    }
}
