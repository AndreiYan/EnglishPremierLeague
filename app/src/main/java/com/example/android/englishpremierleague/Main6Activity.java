package com.example.android.englishpremierleague;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

public class Main6Activity extends AppCompatActivity {

    TextView displayName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String name = extras.getString("QuizName");
        String score = extras.getString("score1");

        displayName = findViewById(R.id.customer_Name);
        displayName.setText(name);

        String Congrats = getResources().getString(R.string.score) + score;
        Toast toast = Toast.makeText(Main6Activity.this,
                Congrats, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();


    }


}




