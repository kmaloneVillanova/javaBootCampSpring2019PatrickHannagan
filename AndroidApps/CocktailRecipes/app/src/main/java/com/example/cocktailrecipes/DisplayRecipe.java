package com.example.cocktailrecipes;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DisplayRecipe extends AppCompatActivity {
    public String selectedRecipe;
    public TextView recipeName;
    public TextView ingredientsUsed;
    public TextView ingredientAmounts;
    public TextView recipeDirections;

    public TextView ingredientsUsed2;
    public TextView ingredientAmounts2;
    public TextView ingredientsUsed3;
    public TextView ingredientAmounts3;
    public TextView ingredientsUsed4;
    public TextView ingredientAmounts4;
    public TextView ingredientsUsed5;
    public TextView ingredientAmounts5;

    public ArrayList<String> ingUsedAL = new ArrayList<>();
    public ArrayList<String> ingAmountsAL = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_recipe);

        Intent intent = getIntent();
        selectedRecipe = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        recipeName = findViewById(R.id.RecipeName);
        recipeName.setText(selectedRecipe);

        ingredientsUsed = findViewById(R.id.IngredientsUsed);
        ingredientAmounts = findViewById(R.id.IngredientAmounts);
        recipeDirections = findViewById(R.id.RecipeDirections);

        ingredientsUsed2 = findViewById(R.id.IngredientsUsed2);
        ingredientAmounts2 = findViewById(R.id.IngredientAmounts2);
        ingredientsUsed3 = findViewById(R.id.IngredientsUsed3);
        ingredientAmounts3 = findViewById(R.id.IngredientAmounts3);
        ingredientsUsed4 = findViewById(R.id.IngredientsUsed4);
        ingredientAmounts4 = findViewById(R.id.IngredientAmounts4);
        ingredientsUsed5 = findViewById(R.id.IngredientsUsed5);
        ingredientAmounts5 = findViewById(R.id.IngredientAmounts5);
/*        FetchDirections fetchDirections = new FetchDirections(ingredientsUsed, ingredientAmounts,
                recipeDirections);
        fetchDirections.execute(selectedRecipe);*/
        FetchDirections fetchDirections = new FetchDirections(recipeDirections,
                ingredientsUsed, ingredientAmounts,
                ingredientsUsed2, ingredientAmounts2,
                ingredientsUsed3, ingredientAmounts3,
                ingredientsUsed4, ingredientAmounts4,
                ingredientsUsed5, ingredientAmounts5);

        /*FetchDetails fetchDetails = new FetchDetails();*/
        fetchDirections.execute(selectedRecipe);
    }


}

/*    public void showSteps(View view) {

 *//*        FetchDirections fetchDirections = new FetchDirections(ingredientsUsed, ingredientAmounts,
                recipeDirections);*//*
        FetchDirections fetchDirections = new FetchDirections(recipeDirections,
                ingredientsUsed, ingredientAmounts,
                ingredientsUsed2, ingredientAmounts2,
                ingredientsUsed3, ingredientAmounts3,
                ingredientsUsed4, ingredientAmounts4,
                ingredientsUsed5, ingredientAmounts5);
        fetchDirections.execute(selectedRecipe);
    }
}*/
