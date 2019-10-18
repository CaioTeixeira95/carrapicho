package com.example.scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int totalPoints = 0;
    int[] choices = new int[10];
    final int[][] values = {
            {4, 2, 3, 1},
            {1, 2, 4, 3},
            {2, 1, 3, 4},
            {3, 4, 1, 2},
            {1, 3, 2, 4},
            {3, 1, 2, 4},
            {4, 3, 1, 2},
            {3, 2, 1, 4},
            {2, 3, 1, 4},
            {1, 4, 3, 2}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalPoints = 0;

        // Getting all radio groups
        RadioGroup radioGroupFistQuestion = findViewById(R.id.radioGroupFirstQuestion);
        RadioGroup radioGroupSecondQuestion = findViewById(R.id.radioGroupSecondQuestion);
        RadioGroup radioGroupThirdQuestion = findViewById(R.id.radioGroupThirdQuestion);
        RadioGroup radioGroupFourthQuestion = findViewById(R.id.radioGroupFourthQuestion);
        RadioGroup radioGroupFifthQuestion = findViewById(R.id.radioGroupFifthQuestion);
        RadioGroup radioGroupSixthQuestion = findViewById(R.id.radioGroupSixthQuestion);
        RadioGroup radioGroupSeventhQuestion = findViewById(R.id.radioGroupSeventhQuestion);
        RadioGroup radioGroupEighthQuestion = findViewById(R.id.radioGroupEighthQuestion);
        RadioGroup radioGroupNinthQuestion = findViewById(R.id.radioGroupNinthQuestion);
        RadioGroup radioGroupTenthQuestion = findViewById(R.id.radioGroupTenthQuestion);

        // Setting the setOnCheckedChangeListener of all Radio Groups
        setChangeListener(radioGroupFistQuestion, 0);
        setChangeListener(radioGroupSecondQuestion, 1);
        setChangeListener(radioGroupThirdQuestion, 2);
        setChangeListener(radioGroupFourthQuestion, 3);
        setChangeListener(radioGroupFifthQuestion, 4);
        setChangeListener(radioGroupSixthQuestion, 5);
        setChangeListener(radioGroupSeventhQuestion, 6);
        setChangeListener(radioGroupEighthQuestion, 7);
        setChangeListener(radioGroupNinthQuestion, 8);
        setChangeListener(radioGroupTenthQuestion, 9);

    }

    public void setChangeListener(RadioGroup radioGroup, final int index) {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                int radioButtonId = radioGroup.getCheckedRadioButtonId();
                View radioButton = radioGroup.findViewById(radioButtonId);
                choices[index] = values[index][radioGroup.indexOfChild(radioButton)];
            }
        });
    }

    public void calculatePoints(View v) {

        for (int i = 0; i < choices.length; i++) {
            // if the choice is the first one
            if (choices[i] == 0) {
                choices[i] = values[i][0];
            }
            totalPoints += choices[i];
        }

        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
        intent.putExtra("totalPoints", totalPoints);
        startActivity(intent);

    }

}
