package com.example.android.englishpremierleague;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


       @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureStartButton();



    }

    public void configureStartButton(){

        Button startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText userName = findViewById(R.id.customer_Name);
                String name = userName.getText().toString();

                if (name != null && !name.isEmpty()) {
                    Intent intent=new Intent(MainActivity.this, Page2Activity.class);
                    Bundle extras = new Bundle();
                    extras.putString("QuizName", name);
                    intent.putExtras(extras);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Please enter your name to start the quiz!", Toast.LENGTH_SHORT).show();
                    return;
                }


            }
        });
        }


    }


