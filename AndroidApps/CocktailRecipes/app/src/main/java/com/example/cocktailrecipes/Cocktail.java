package com.example.cocktailrecipes;

import android.util.Log;

import java.util.ArrayList;

public class Cocktail {
    String name;
    String[] ingredients;
    String LOG_TAG = "Ingredients Check";

    Cocktail(String name, String[] ingredients){
        this.name=name;
        this.ingredients=ingredients;
    }

    public String getName(){
        return name;
    }

    public boolean checkIngredients(ArrayList<String> selectedIngredients){
        int numIngredients = ingredients.length;
        int ingredientsFound = 0;
        for(int i = 0; i < numIngredients; i++){
            for(int j = 0; j < selectedIngredients.size(); j++){
                if((selectedIngredients.get(j)).equals(ingredients[i])){
                    ingredientsFound=ingredientsFound+1;
                }
            }
        }
        Log.d(LOG_TAG,String.valueOf(ingredientsFound));
        if(ingredientsFound==numIngredients){
            Log.d(LOG_TAG,"Equal num of ingredients and ingredients found");
            return true;
        } else {
            Log.d(LOG_TAG,"Ingredients not found");
            return false;
        }
    }
}
