package com.example.cocktailrecipes;

import android.arch.lifecycle.LiveData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.cocktailrecipes.extra.MESSAGE";
    public String selectedRecipe;

    public ArrayList<String> selectedIngredients = new ArrayList<>();
    public ArrayList<String> possibleRecipes = new ArrayList<>();
    public ListView listOfIngredients;
    public ListAdapter listOfIngredientsAdapter;
    public ListView listOfRecipes;
    public ListAdapter listOfRecipesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listOfIngredients = (ListView) findViewById(R.id.listOfIngredients);
        listOfIngredients.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        String[] ingredients = {"Vodka", "Rum", "Whiskey", "Tequila", "Gin", "Lemon Juice",
                "Lime Juice", "Simple Syrup", "Sugar", "Dry Vermouth", "Sweet Vermouth", "Bitters",
                "Grenadine", "Tonic Water", "Soda Water", "Triple Sec", "Ginger Beer"};

        listOfIngredientsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, ingredients);
        listOfIngredients.setAdapter(listOfIngredientsAdapter);
        listOfIngredients.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = ((TextView)view).getText().toString();

                if(selectedIngredients.contains(selectedItem)){
                    selectedIngredients.remove(selectedItem);
                } else {
                    selectedIngredients.add(selectedItem);
                }
            }
        });

        listOfRecipes = (ListView) findViewById(R.id.listOfRecipes);
        listOfRecipes.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listOfRecipesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item,possibleRecipes);
        listOfRecipes.setAdapter(listOfRecipesAdapter);
        listOfRecipes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedRecipe = ((TextView)view).getText().toString();

                Intent intent = new Intent(view.getContext(), DisplayRecipe.class);
                intent.putExtra(EXTRA_MESSAGE, selectedRecipe);
                startActivity(intent);
            }
        });
    }

    public void showRecipes(View view) {
        possibleRecipes.clear();

        Cocktail[] cocktailDirectory = new Cocktail[10];
        String[] ings1 = {"Whiskey","Lemon Juice","Simple Syrup"};
        String[] ings2 = {"Tequila", "Triple Sec", "Lime Juice"};
        String[] ings3 = {"Rum", "Lime Juice", "Simple Syrup", "Grenadine"};
        String[] ings4 = {"Gin","Dry Vermouth"};
        String[] ings5 = {"Whiskey","Sweet Vermouth","Bitters"};
        String[] ings6 = {"Rum","Lime Juice","Simple Syrup"};
        String[] ings7 = {"Gin","Dry Vermouth"};
        String[] ings8 = {"Gin","Lime Juice","Bitters","Simple Syrup","Soda Water"};
        String[] ings9 = {"Vodka","Lime Juice","Bitters","Tonic Water"};
        String[] ings10 = {"Vodka","Ginger Beer","Lime Juice"};

        cocktailDirectory[0] = new Cocktail("Whiskey Sour",ings1);
        cocktailDirectory[1] = new Cocktail("Margarita",ings2);
        cocktailDirectory[2] = new Cocktail("Bacardi Cocktail",ings3);
        cocktailDirectory[3] = new Cocktail("Martini",ings4);
        cocktailDirectory[4] = new Cocktail("Manhattan",ings5);
        cocktailDirectory[5] = new Cocktail("Daiquiri",ings6);
        cocktailDirectory[6] = new Cocktail("Addison",ings7);
        cocktailDirectory[7] = new Cocktail("Gin Swizzle",ings8);
        cocktailDirectory[8] = new Cocktail("Long Vodka",ings9);
        cocktailDirectory[9] = new Cocktail("Moscow Mule",ings10);

        for(int i = 0; i <= 9; i++){
            if(cocktailDirectory[i].checkIngredients(selectedIngredients)){
                possibleRecipes.add(cocktailDirectory[i].getName());
            }
        }

        ((BaseAdapter) listOfRecipesAdapter).notifyDataSetChanged();
    }

}
