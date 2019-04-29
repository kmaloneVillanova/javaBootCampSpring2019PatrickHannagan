package com.example.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE =
            "com.example.android.FinalProject.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;

/*    private boolean[] selectedIngredients = {false, true, false, false, false, false, false, false,
            false, false, false, false, false};*/

    ArrayList<String> selectedIngredients = new ArrayList<String>();
    ArrayList<String> ingredientsToDisplay = new ArrayList<String>();

    /*private boolean[] selectedIngredients;*/
    /*public String[] ingredientsToDisplay;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchIngredientList(View view) {
        Intent intent = new Intent(this, IngredientList.class);
        intent.putExtra(EXTRA_MESSAGE, selectedIngredients);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void printSelectedIngredients(View view) {
        String[] ingredientsToDisplay = {"Vodka", "Rum", "Whiskey", "Tequila", "Gin", "Lemon Juice",
                "Lime Juice", "Simple Syrup", "Orange Juice", "Soda Water", "Tonic Water",
                "Dry Vermouth", "Sweet Vermouth", "Bitters"};

        selectedIngredients.add("Vodka");
        selectedIngredients.add("Lime Juice");
        selectedIngredients.add("Soda Water");

        /*Toast.makeText(MainActivity.this, ingredients[3], Toast.LENGTH_LONG);*/
/*        for(int i=0;i<14;i++){
            if(selectedIngredients[i]){
                *//*ingredientsToDisplay[i]=ingredients[i];*//*
                String selectedIngredient = String.valueOf(ingredients[i]);
                Toast.makeText(MainActivity.this, selectedIngredient, Toast.LENGTH_LONG);
            } else {
                *//*ingredientsToDisplay[i]="N/A";*//*
            }
        }*/
/*        ListAdapter listOfIngredientsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, ingredientsToDisplay);
        ListView listOfIngredients = (ListView) findViewById(R.id.listOfIngredients);
        listOfIngredients.setAdapter(listOfIngredientsAdapter);*/

        ListAdapter listOfIngredientsAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                selectedIngredients);
        ListView listOfIngredients = (ListView) findViewById(R.id.listOfIngredients);
        listOfIngredients.setAdapter(listOfIngredientsAdapter);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                selectedIngredients = data.getStringArrayListExtra(IngredientList.EXTRA_REPLY);
/*                boolean[] reply = data.getBooleanArrayExtra(IngredientList.EXTRA_REPLY);
                selectedIngredients=reply;*/

            }
        }
    }
}
