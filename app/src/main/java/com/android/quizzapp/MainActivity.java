package com.android.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {
    public static int total;
    public static int correct;
    public static int wrong;
    RadioGroup radio_Q1, radio_Q2, radio_Q3, radio_Q4, radio_Q5, radio_Q6, radio_Q7, radio_Q8, radio_Q9, radio_Q10;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radio_Q1 = (RadioGroup) findViewById(R.id.question_one);
        radio_Q2 = (RadioGroup) findViewById(R.id.question_two);
        radio_Q3 = (RadioGroup) findViewById(R.id.question_three);
        radio_Q4 = (RadioGroup) findViewById(R.id.question_four);
        radio_Q5 = (RadioGroup) findViewById(R.id.question_five);
        radio_Q6 = (RadioGroup) findViewById(R.id.question_six);
        radio_Q7 = (RadioGroup) findViewById(R.id.question_seven);
        radio_Q8 = (RadioGroup) findViewById(R.id.question_eight);
        radio_Q9 = (RadioGroup) findViewById(R.id.question_nine);
        radio_Q10 = (RadioGroup) findViewById(R.id.question_ten);
        submitButton = (Button) findViewById(R.id.submit_button);

    }

    void startQuiz() {
        Questions q1 = new Questions(getString(R.string.question1), getString(R.string.q1op1), getString(R.string.q1op2), getString(R.string.q1op3), getString(R.string.q1op4), new Answer(getString(R.string.q1op2)));
        Questions q2 = new Questions(getString(R.string.question2), getString(R.string.q2op1), getString(R.string.q2op2), getString(R.string.q2op3), getString(R.string.q2op4), new Answer(getString(R.string.q2op2)));
        Questions q3 = new Questions(getString(R.string.question3), getString(R.string.q3op1), getString(R.string.q3op2), getString(R.string.q3op3), getString(R.string.q3op4), new Answer(getString(R.string.q3op3)));
        Questions q4 = new Questions(getString(R.string.question4), getString(R.string.q4op1), getString(R.string.q4op2), getString(R.string.q4op3), getString(R.string.q4op4), new Answer(getString(R.string.q4op4)));
        Questions q5 = new Questions(getString(R.string.question5), getString(R.string.q5op1), getString(R.string.q5op2), getString(R.string.q5op3), getString(R.string.q5op4), new Answer(getString(R.string.q5op2)));
        Questions q6 = new Questions(getString(R.string.question6), getString(R.string.q6op1), getString(R.string.q6op2), getString(R.string.q6op3), getString(R.string.q6op4), new Answer(getString(R.string.q6op3)));
        Questions q7 = new Questions(getString(R.string.question7), getString(R.string.q7op1), getString(R.string.q7op2), getString(R.string.q7op3), getString(R.string.q7op4), new Answer(getString(R.string.q7op1)));
        Questions q8 = new Questions(getString(R.string.question8), getString(R.string.q8op1), getString(R.string.q8op2), getString(R.string.q8op3), getString(R.string.q8op4), new Answer(getString(R.string.q8op4)));
        Questions q9 = new Questions(getString(R.string.question9), getString(R.string.q9op1), getString(R.string.q9op2), getString(R.string.q9op3), getString(R.string.q9op4), new Answer(getString(R.string.q9op2)));
        Questions q10 = new Questions(getString(R.string.question10), getString(R.string.q1op1), getString(R.string.q10op2), getString(R.string.q10op3), getString(R.string.q10op4), new Answer(getString(R.string.q10op4)));

        Questions[] questionsArr = {q1, q2, q3, q4, q5, q6, q7, q8, q9, q10};

        RadioGroup radioGroup[] = {radio_Q1, radio_Q2, radio_Q3, radio_Q4, radio_Q5, radio_Q6, radio_Q7, radio_Q8, radio_Q9, radio_Q10};

        String answers[] = new String[10];
        int counter = 0;
        for (RadioGroup r : radioGroup) {
            int selectedId = r.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = (RadioButton) findViewById(selectedId);
            answers[counter] = selectedRadioButton.getText().toString();
            counter++;
        }

        for (String st : answers) {
            String k = st;
            System.out.println(k);
        }
        int i = 0;
        for (Questions q : questionsArr) {
            String ans = q.getAnswer1().getAnswer();
            String ansss = answers[i];
            if (ans.equals(answers[i])) {
                correct++;
            } else {
                wrong++;
            }
            total++;
            i++;
        }


    }


    public void showResults(View view) {
        startQuiz();
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        startActivity(intent);
    }
}
