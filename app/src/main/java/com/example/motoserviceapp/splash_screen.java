package com.example.motoserviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class splash_screen extends AppCompatActivity {

    ProgressBar progressBar;
    ObjectAnimator progressAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        progressAnimation();

        progressAnimator.setDuration(5000);

        progressAnimator.start();

        progressAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(getBaseContext(), "Loaded Successfully", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
                Intent intent = new Intent(splash_screen.this, add_Services.class);
                startActivity(intent);

            }

        });
    }

    private void progressAnimation(){
        progressBar = findViewById(R.id.progressBar);
        progressAnimator = ObjectAnimator.ofInt(progressBar, "progress", 0,100);

    }

}