package com.example.android.englishpremierleague;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main6Activity extends AppCompatActivity {

    TextView displayName;
    TextView displaycustmoerScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String name = extras.getString("QuizName");

        displayName = findViewById(R.id.customer_Name);
        displayName.setText(name);
        String score = extras.getString("finalScore");
        displaycustmoerScore = findViewById(R.id.customer_Score);
        displaycustmoerScore.setText(score);

    }



}




