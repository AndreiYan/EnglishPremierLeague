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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        configureStartButton();
        setSubmit2Button();
        setSubmit3Button();
        setSubmit4Button();

        Bundle extras = getIntent().getExtras();
        String name2 = extras.getString("QuizName");
        theName = name2;
    }


    public void setSubmit2Button() {

        Button submit2Button = findViewById(R.id.submit2);
        submit2Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                RadioGroup radioGroup = findViewById(R.id.RadioGrouptotts);
                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (checkedRadioButtonId == 3) {
                    score = score + 3;
                }

            }


        });

    }

    public void setSubmit3Button() {

        Button submit3Button = findViewById(R.id.submit3);
        submit3Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                EditText name = findViewById(R.id.manager_Name);
                String managersName = name.getText().toString();
                if (name != null && managersName.equals("Wenger")) {
                    score = score + 3;
                } else {
                    Toast.makeText(Page2Activity.this, "Please enter the Last Name", Toast.LENGTH_SHORT).show();


                }

            }


        });


    }

    public void setSubmit4Button() {

        Button submit4Button = findViewById(R.id.submit4);
        submit4Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                switch (view.getId()) {
                    case R.id.checkboxArsenal:
                        if (checked)
                            score = score + 1;
                        break;

                    case R.id.checkboxChelsea:
                        if (checked)
                            score = score + 1;

                        break;

                    case R.id.checkboxEverton:
                        if (checked)
                            score = score + 1;

                        break;

                    case R.id.checkboxLiverpool:
                        if (checked)
                            score = score + 1;

                        break;
                    case R.id.checkboxMunt:
                        if (checked)
                            score = score + 1;

                        break;
                    case R.id.checkboxTotts:
                        if (checked)
                            score = score + 1;

                        break;

                }


            }


        });


    }

    public void configureStartButton() {

        Button startButton = findViewById(R.id.score);
        startButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                RadioGroup radioGroup = findViewById(R.id.RadioGroupMut);
                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (checkedRadioButtonId == 1) {
                    score = score + 3;
                }

                String finalName = theName;
                String finalScore = Integer.toString(score);
                Intent intent = new Intent(Page2Activity.this, Main6Activity.class);
                Bundle extras = new Bundle();
                extras.putString("QuizName", finalName);
                extras.putInt(finalScore, score);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });


    }

}