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
    CheckBox Ch1, Ch2, Ch3, Ch4, Ch5, Ch6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        Ch1 = findViewById(R.id.checkboxArsenal);
        Ch2 = findViewById(R.id.checkboxChelsea);
        Ch3 = findViewById(R.id.checkboxEverton);
        Ch4 = findViewById(R.id.checkboxLiverpool);
        Ch5 = findViewById(R.id.checkboxMunt);
        Ch6 = findViewById(R.id.checkboxTotts);

        configureStartButton();

        Bundle extras = getIntent().getExtras();
        String name2 = extras.getString("QuizName");
        theName = name2;
    }

    public void configureStartButton() {

        Button startButton = findViewById(R.id.score);
        startButton.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view) {

                RadioGroup radioGroup2 = findViewById(R.id.RadioGroupMut);
                int checkedRadioButtonId2 = radioGroup2.getCheckedRadioButtonId();
                if (checkedRadioButtonId2 == 1) {
                    score = score + 3;
                }

                RadioGroup radioGroup1 = findViewById(R.id.RadioGrouptotts);
                int checkedRadioButtonId1 = radioGroup1.getCheckedRadioButtonId();
                if (checkedRadioButtonId1 == 3) {
                    score = score + 3;
                }

                EditText name = findViewById(R.id.manager_Name);
                String managersName = name.getText().toString();
                if (name != null && managersName.equals("Wenger")) {
                    score = score + 3;
                } else {
                    Toast.makeText(Page2Activity.this, "Please enter the Last Name", Toast.LENGTH_SHORT).show();

                }


                if (Ch1.isChecked() && Ch2.isChecked() &&
                        Ch3.isChecked() && Ch4.isChecked() &&
                        Ch5.isChecked() && Ch6.isChecked()) {
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
            }
        });


    }

}
