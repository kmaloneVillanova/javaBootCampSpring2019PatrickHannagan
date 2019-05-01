package com.example.cocktailrecipes;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class FetchDirections extends AsyncTask <String, Void, String> {

    private WeakReference<TextView> ingredientsUsed;
    private WeakReference<TextView> ingredientAmounts;
    private WeakReference<TextView> recipeDirections;

    private WeakReference<TextView> ingredientsUsed2;
    private WeakReference<TextView> ingredientAmounts2;
    private WeakReference<TextView> ingredientsUsed3;
    private WeakReference<TextView> ingredientAmounts3;
    private WeakReference<TextView> ingredientsUsed4;
    private WeakReference<TextView> ingredientAmounts4;
    private WeakReference<TextView> ingredientsUsed5;
    private WeakReference<TextView> ingredientAmounts5;


    private static final String BASE_URL =
            "https://www.thecocktaildb.com/api/json/v1/1/search.php?";
    private static final String QUERY_PARAM = "s";

    FetchDirections(TextView recipeDirections,
                    TextView ingredientsUsed, TextView ingredientAmounts,
                    TextView ingredientsUsed2, TextView ingredientAmounts2,
                    TextView ingredientsUsed3, TextView ingredientAmounts3,
                    TextView ingredientsUsed4, TextView ingredientAmounts4,
                    TextView ingredientsUsed5, TextView ingredientAmounts5){
        this.recipeDirections = new WeakReference<>(recipeDirections);
        this.ingredientsUsed = new WeakReference<>(ingredientsUsed);
        this.ingredientAmounts = new WeakReference<>(ingredientAmounts);


        this.ingredientsUsed2 = new WeakReference<>(ingredientsUsed2);
        this.ingredientAmounts2 = new WeakReference<>(ingredientAmounts2);
        this.ingredientsUsed3 = new WeakReference<>(ingredientsUsed3);
        this.ingredientAmounts3 = new WeakReference<>(ingredientAmounts3);
        this.ingredientsUsed4 = new WeakReference<>(ingredientsUsed4);
        this.ingredientAmounts4 = new WeakReference<>(ingredientAmounts4);
        this.ingredientsUsed5 = new WeakReference<>(ingredientsUsed5);
        this.ingredientAmounts5 = new WeakReference<>(ingredientAmounts5);
    }


    @Override
    protected String doInBackground(String... strings) {
        String recipeQuery = strings[0];
        HttpURLConnection urlConnection;
        BufferedReader reader;
        String jsonResponse = null;

        Uri buildURL = Uri.parse(BASE_URL).buildUpon().appendQueryParameter(QUERY_PARAM,
                recipeQuery).build();

        Log.d("URL", buildURL.toString());


        try {
            URL apiURL = new URL(buildURL.toString());
            urlConnection=(HttpURLConnection)apiURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream=urlConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
            String line = reader.readLine();
            while(line != null){
                builder.append(line);
                builder.append("\n");
                line = reader.readLine();
            }
            if(builder.length()==0){
                return null;
            }
            jsonResponse = builder.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("JSON RESPONSE", jsonResponse);
        return jsonResponse;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        String directions = null;
        String ingUsed = null;
        String ingAmounts = null;

        String ingUsed2 = null;
        String ingAmounts2 = null;
        String ingUsed3 = null;
        String ingAmounts3 = null;
        String ingUsed4 = null;
        String ingAmounts4 = null;
        String ingUsed5 = null;
        String ingAmounts5 = null;

        try {
/*            JSONObject cocktail = new JSONObject(s);
            JSONObject cocktailID = cocktail.getJSONObject("idDrink");
            directions = cocktail.getString("strInstructions");

            ingUsed = cocktail.getString("strIngredient1");

            ingAmounts = cocktail.getString("strMeasure1");*/

            JSONObject cocktail = new JSONObject(s);
            JSONArray itemsArray = cocktail.getJSONArray("drinks");
            for(int i=0;i<itemsArray.length();i++){
                JSONObject aCocktail = itemsArray.getJSONObject(i);
                Log.d("JSON RESPONSE", aCocktail.toString());
                /*JSONObject drinkName = aCocktail.getJSONObject("strDrink");*/
                directions = aCocktail.getString("strInstructions");
                Log.d("JSON RESPONSE", directions);
                ingUsed = aCocktail.getString("strIngredient1");
                ingAmounts = aCocktail.getString("strMeasure1");

                ingUsed2 = aCocktail.getString("strIngredient2");
                ingAmounts2 = aCocktail.getString("strMeasure2");
                ingUsed3 = aCocktail.getString("strIngredient3");
                ingAmounts3 = aCocktail.getString("strMeasure3");
                ingUsed4 = aCocktail.getString("strIngredient4");
                ingAmounts4 = aCocktail.getString("strMeasure4");
                ingUsed5 = aCocktail.getString("strIngredient5");
                ingAmounts5 = aCocktail.getString("strMeasure5");


                if(ingUsed != null && ingAmounts != null){
                    break;
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        recipeDirections.get().setText(directions);
        ingredientsUsed.get().setText(ingUsed);
        ingredientAmounts.get().setText(ingAmounts);

        ingredientsUsed2.get().setText(ingUsed2);
        ingredientAmounts2.get().setText(ingAmounts2);
        ingredientsUsed3.get().setText(ingUsed3);
        ingredientAmounts3.get().setText(ingAmounts3);
        ingredientsUsed4.get().setText(ingUsed4);
        ingredientAmounts4.get().setText(ingAmounts4);
        ingredientsUsed5.get().setText(ingUsed5);
        ingredientAmounts5.get().setText(ingAmounts5);

    }
}
