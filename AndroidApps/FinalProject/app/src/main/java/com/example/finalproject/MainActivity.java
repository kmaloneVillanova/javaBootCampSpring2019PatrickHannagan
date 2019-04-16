package com.example.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchIngredientList(View view) {
        Intent intent = new Intent(this, IngredientList.class);
        startActivity(intent);
    }

    public void printSelectedIngredients(View view) {

    }
}
