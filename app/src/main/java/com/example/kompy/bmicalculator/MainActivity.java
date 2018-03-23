package com.example.kompy.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText mHeight, mWeight;
    TextView mNumbericResult, mTextResult, mDescription;
    Button mCalculate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHeight = (EditText) findViewById(R.id.height);
        mWeight = (EditText) findViewById(R.id.weight);
        mNumbericResult = (TextView) findViewById(R.id.numeric_result);
        mTextResult = (TextView) findViewById(R.id.text_result);
        mDescription = (TextView) findViewById(R.id.description);
        mCalculate = (Button) findViewById(R.id.calculate);

        mCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI(){
        String heightStr = mHeight.getText().toString();
        String weightStr = mWeight.getText().toString();

        if (heightStr.length() > 0 && weightStr.length() > 0) {
            float heightValue = Float.parseFloat(heightStr);
            float weightValue = Float.parseFloat(weightStr);
            float bmi = weightValue/(heightValue*heightValue);
            displayBmi(bmi);
        }
    }

    private void displayBmi(float bmi) {
        String bmiLabel2;
        String bmiLabel3;

        if (Float.compare(bmi, 18.5f) <= 0 ) {
            bmiLabel2 = getString(R.string.underweight);
            bmiLabel3 = getString(R.string.underweight_message);
        } else if (Float.compare(bmi, 18.5f)  > 0 && Float.compare(bmi, 25f)<= 0)  {
            bmiLabel2= getString(R.string.healthy);
            bmiLabel3= getString(R.string.healthy_message);
        } else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <= 0){
            bmiLabel2= getString(R.string.overweight);
            bmiLabel3= getString(R.string.overweight_message);
        } else if (Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 40f) <= 0) {
            bmiLabel2= getString(R.string.obese);
            bmiLabel3= getString(R.string.obese_message);
        } else {
            bmiLabel2= getString(R.string.obese_class_2);
            bmiLabel3= getString(R.string.obese_2_message);
        }
        mNumbericResult.setText(String.valueOf(bmi));
        mTextResult.setText(bmiLabel2);
        mDescription.setText(bmiLabel3);
    }
}
