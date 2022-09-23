package com.hfad.dormandmealplanann;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

//@ Author: Angel Negron


/*
This app allows a user to select a dorm room and a
meal plan, and have the cost calculated and displayed for them.
It uses spinners to allow for the user to choose what option
they want to see, and then a button is used to calculate the costs.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFindCost = (Button) findViewById(R.id.cost); //Button that calculates cost
        TextView tvCosts = (TextView) findViewById(R.id.total); //Text View that shows total cost
        Spinner spinDorm = (Spinner) findViewById(R.id.dorm); //Spinner that contains dorms
        Spinner spinMeal = (Spinner) findViewById(R.id.meals); //Spinner that contains meals
        btnFindCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cost = spinDorm.getSelectedItem().toString();
                String meal = spinMeal.getSelectedItem().toString();
                //Displays the cost of the two selected items
                tvCosts.setText("$" + getTotalCost(getDormCosts(cost),getMealCosts(meal)));
            }
        });



    }

    //Gets the meal cost depending on what is selected
    public int getMealCosts(String cost) {
        if(cost.equals("7 meals per week $600"))
            return 600;
       else if(cost.equals("14 meals per week $1100"))
            return 1100;
       else
           return 1800;
    }

    //Gets the dorm cost depending on what is selected
    public int getDormCosts(String cost) {
        if(cost.equals("Allen Hall $1800 per semester"))
            return 1800;
        else if(cost.equals("Pike Hall $2200 per semester"))
            return 2200;
        else if (cost.equals("Farthing $2800 per semester"))
            return 2800;
        else
            return 3000;
    }


    //Gets the total cost of dorm and meal, and the converts the
    //total into a string that can be displayed.
    public String getTotalCost(int meal,int dorm)
    {
        return Integer.toString(meal+dorm);
    }

}