package com.example.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    int RandomNumberGenerated;
    int attempts =0;

    public void randomMethod(){
        Random rand = new Random();
        RandomNumberGenerated = 1+ rand.nextInt(20);

    }



    public void NewNumOnClick (View view){
        randomMethod();
        Toast.makeText(this,"A NEW RANDOM NUMBER HAS BEEN GENERATED", Toast.LENGTH_LONG).show();

    }


    public void GuessOnClick(View view){
        attempts+=1;
        EditText numberGuessed = (EditText) findViewById(R.id.numberGuessedET);
        int input = Integer.parseInt(numberGuessed.getText().toString()); //converts user's input (type EditText) to an int
        Log.i("Status : " , "The user entered " + input);

        if (input > 20 || input < 1){
            Toast.makeText(this,"The number you entered is out of range. Please enter #1-20", Toast.LENGTH_LONG).show();
        }

        if(input > RandomNumberGenerated){
            Toast.makeText(this,"Try a lower number", Toast.LENGTH_LONG).show();

        }
        if (input < RandomNumberGenerated)
            Toast.makeText(this,"Try a higher number", Toast.LENGTH_LONG).show();

        if (RandomNumberGenerated == input){
            Toast.makeText(this,"YOU GUESSED IT RIGHT! IT TOOK YOU "+ attempts + " ATTEMPTS", Toast.LENGTH_LONG).show();
            attempts =0;

        }


       numberGuessed.getText().clear(); // after user presses GUESS button, it clears text field so a new number can be inputted


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomMethod();


    }
}
