package com.example.android.englishpremierleague;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Page2Activity extends AppCompatActivity {
    String theName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        configureStartButton();

        Bundle extras = getIntent().getExtras();
        String name2 = extras.getString("QuizName");
        theName = name2;
    }

    public void configureStartButton(){

        Button startButton = findViewById(R.id.score);
        startButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String finalName = theName;
                Intent intent = new Intent(Page2Activity.this, Main6Activity.class);
                Bundle extras = new Bundle();
                extras.putString("QuizName", finalName);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });




          }



}
