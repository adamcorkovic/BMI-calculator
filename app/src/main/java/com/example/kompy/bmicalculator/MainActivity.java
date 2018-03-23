package com.example.kompy.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText height, weight;
    TextView  numericresult, textresult, description;
    Button calculate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        numericresult = (TextView) findViewById(R.id.numericresult);
        textresult = (TextView) findViewById(R.id.textresult);
        description = (TextView) findViewById(R.id.description);
        calculate = (Button) findViewById(R.id.calculate);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI(){
        String heightStr = height.getText() .toString();
        String weightStr = weight.getText() .toString();

        if (heightStr != null && !"" .equals(heightStr) && weightStr != null && !"" .equals(weightStr)){
            float heightValue = Float.parseFloat(heightStr);
            float weightValue = Float.parseFloat(weightStr);

            float BMI = weightValue/ (heightValue*heightValue);

            displayBMI(BMI);
        }


    }

    private void displayBMI(float BMI) {
        String bmiLabel = "";
        String bmiLabel2 = "";
        String bmiLabel3 = "";

        if (Float.compare(BMI, 18.5f)<= 0 ){
            bmiLabel2 = "Underweight";
            bmiLabel3 = "Very severly underweight!";
        } else if (Float.compare(BMI, 18.5f)> 0 && Float.compare(BMI, 25f)<= 0){
            bmiLabel2= "Healthy";
            bmiLabel3= "Your BMI is normal range!";
        } else if (Float.compare(BMI, 25f)> 0 && Float.compare(BMI, 30f)<=0){
            bmiLabel2= "Overweight";
            bmiLabel3= "Your BMI is high!";
        }else if (Float.compare(BMI, 30f)> 0 && Float.compare(BMI, 40f)<=0){
            bmiLabel2= "Obese clase 1";
            bmiLabel3= "Your BMI is high!";
        } else {
            bmiLabel2= "Obese clase 2";
            bmiLabel3= "Your BMI is to high!";

        }
          bmiLabel= BMI+"\n"+ bmiLabel;
        numericresult.setText(bmiLabel);
        textresult.setText(bmiLabel2);
        description.setText(bmiLabel3);


    }


}
