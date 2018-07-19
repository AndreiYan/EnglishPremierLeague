package com.example.android.englishpremierleague;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;


public class Page2Activity extends AppCompatActivity {
    String theName;
    int score = 0;
    CheckBox q3_Ch1, q3_Ch2, q3_Ch3, q3_Ch4, q3_Ch5, q3_Ch6, q3_Ch7, q3_Ch8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        q3_Ch1 = findViewById(R.id.checkboxArsenal);
        q3_Ch2 = findViewById(R.id.checkboxChelsea);
        q3_Ch3 = findViewById(R.id.checkboxEverton);
        q3_Ch4 = findViewById(R.id.checkboxLiverpool);
        q3_Ch5 = findViewById(R.id.checkboxMunt);
        q3_Ch6 = findViewById(R.id.checkboxTotts);
        q3_Ch7 = findViewById(R.id.checkboxMcity);
        q3_Ch8 = findViewById(R.id.checkboxWham);

        configureStartButton();

        Bundle extras = getIntent().getExtras();
        String name2 = extras.getString("QuizName");
        theName = name2;
    }

    public void configureStartButton() {
        Button startButton = findViewById(R.id.score);
        startButton.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view) {

                RadioGroup radioGroup1 = findViewById(R.id.RadioGrouptotts);
                int checkedRadioButtonId1 = radioGroup1.getCheckedRadioButtonId();
                if (checkedRadioButtonId1 == 3) {
                    score = score + 3;
                }

                RadioGroup radioGroup2 = findViewById(R.id.RadioGroupMut);
                int checkedRadioButtonId2 = radioGroup2.getCheckedRadioButtonId();
                if (checkedRadioButtonId2 == 1) {
                    score = score + 3;
                }

                EditText name = findViewById(R.id.manager_Name);
                String managersName = name.getText().toString();
                if (name != null && managersName.equalsIgnoreCase("Wenger")) {
                    score = score + 3;
                } else {
                    Toast.makeText(Page2Activity.this, "Please enter the Last Name", Toast.LENGTH_SHORT).show();
                }

                if (q3_Ch1.isChecked() && q3_Ch2.isChecked() &&
                        q3_Ch3.isChecked() && q3_Ch4.isChecked() &&
                        q3_Ch5.isChecked() && q3_Ch6.isChecked() && !q3_Ch7.isChecked() && !q3_Ch8.isChecked()) {
                    score = score + 3;
                } else {
                    score = score + 0;
                }

                String finalName = theName;
                String finalScore = Integer.toString(score);
                Intent intent = new Intent(Page2Activity.this, Main6Activity.class);
                Bundle extras = new Bundle();
                extras.putString("QuizName", finalName);
                extras.putString("score1", finalScore);
                intent.putExtras(extras);
                startActivity(intent);
                score = 0;
            }
        });
    }
}
