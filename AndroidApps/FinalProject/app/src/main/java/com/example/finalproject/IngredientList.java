package com.example.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class IngredientList extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.finalproject.IngredientList.extra.reply";


    public boolean selectedIngredients[] = {false, false, false, false, false, false, false, false,
            false, false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_list);
        String[] ingredients = {"Vodka", "Rum", "Whiskey", "Tequila", "Gin", "Lemon Juice",
                "Lime Juice", "Simple Syrup", "Orange Juice", "Soda Water", "Tonic Water",
                "Dry Vermouth", "Sweet Vermouth", "Bitters"};
        ListAdapter listOfIngredientsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, ingredients);
        ListView listOfIngredients = (ListView) findViewById(R.id.listOfIngredients);
        listOfIngredients.setAdapter(listOfIngredientsAdapter);

        listOfIngredients.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedIngredient = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(IngredientList.this, selectedIngredient, Toast.LENGTH_LONG );

                    }
                }
        );

        listOfIngredients.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedIngredients[position]=true;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
