package com.target.dealbrowserpoc.targetdeal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.target.dealbrowserpoc.targetdeal.activity.TargetSplashActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loginClick(View view){
        Intent intent = new Intent(this, TargetSplashActivity.class);
        startActivity(intent);

    }
}
