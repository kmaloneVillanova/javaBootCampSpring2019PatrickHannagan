package com.example.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class IngredientList extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.FinalProject.IngredientList.extra.REPLY";

    ArrayList<String> selectedIngredients = new ArrayList<>();

/*
    public boolean[] selectedIngredients = {false, false, false, false, false, false, false, false,
            false, false, false, false, true};
*/

    /*public boolean[] selectedIngredients;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_list);
        Intent intent = getIntent();
        boolean[] message = intent.getBooleanArrayExtra(MainActivity.EXTRA_MESSAGE);
        String[] ingredients = {"Vodka", "Rum", "Whiskey", "Tequila", "Gin", "Lemon Juice",
                "Lime Juice", "Simple Syrup", "Orange Juice", "Soda Water", "Tonic Water",
                "Dry Vermouth", "Sweet Vermouth", "Bitters"};
/*        for(int i=0;i<ingredients.length;i++){
            selectedIngredients[i]=false;
        }*/
        ListAdapter listOfIngredientsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, ingredients);
        ListView listOfIngredients = (ListView) findViewById(R.id.listOfIngredients);
        listOfIngredients.setAdapter(listOfIngredientsAdapter);

    /*        for(int i=0;i<ingredients.length;i++){
                if(selectedIngredients[i]==true){
                    listOfIngredients.setItemChecked(i, true);
                }

            }*/
/*        listOfIngredients.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedIngredient = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(IngredientList.this, selectedIngredient, Toast.LENGTH_LONG );

                    }
                }
        );*/

        listOfIngredients.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedIngredient = String.valueOf(parent.getItemAtPosition(position));
                selectedIngredients.add(selectedIngredient);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void returnIngredients(View view){
/*        boolean[] reply = selectedIngredients;*/
        Intent replyIntent = new Intent();
/*        replyIntent.putExtra(EXTRA_REPLY, reply);*/
        replyIntent.putExtra(EXTRA_REPLY, selectedIngredients);
        setResult(RESULT_OK,replyIntent);
        finish();
    }
}
