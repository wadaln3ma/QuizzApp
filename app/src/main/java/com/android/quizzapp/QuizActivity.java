package com.android.quizzapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    public int total, wrong, correct, counter = 0;
    public RadioGroup radio_Q1, radio_Q3, radio_Q4, radio_Q5, radio_Q7, radio_Q8, radio_Q9;
    CheckBox checkBoxOne, checkBoxTwo, checkBoxThree, checkBoxFour, checkBoxFive, checkBoxSix;
    EditText editText;
    boolean checkOptionOne, checkOptionTwo, checkOptionThree, checkOptionFour, checkOptionFive, checkOptionSix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        checkBoxOne = (CheckBox) findViewById(R.id.q2op1);
        checkBoxTwo = (CheckBox) findViewById(R.id.q2op2);
        checkBoxThree = (CheckBox) findViewById(R.id.q2op3);
        checkBoxFour = (CheckBox) findViewById(R.id.q2op4);
        checkBoxFive = (CheckBox) findViewById(R.id.q6op1);
        checkBoxSix = (CheckBox) findViewById(R.id.q6op2);
        radio_Q1 = (RadioGroup) findViewById(R.id.question_one);
        radio_Q3 = (RadioGroup) findViewById(R.id.question_three);
        radio_Q4 = (RadioGroup) findViewById(R.id.question_four);
        radio_Q5 = (RadioGroup) findViewById(R.id.question_five);
        radio_Q7 = (RadioGroup) findViewById(R.id.question_seven);
        radio_Q8 = (RadioGroup) findViewById(R.id.question_eight);
        radio_Q9 = (RadioGroup) findViewById(R.id.question_nine);
        editText = (EditText) findViewById(R.id.question_ten_edit);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            correct = extras.getInt("correct");
            wrong = extras.getInt("wrong");
            total = extras.getInt("total");
        }
    }

    void startQuiz() {
        Questions q1 = new Questions(getString(R.string.question1), getString(R.string.q1op1), getString(R.string.q1op2), getString(R.string.q1op3), getString(R.string.q1op4), new Answer(getString(R.string.q1op2)));
        Questions q3 = new Questions(getString(R.string.question3), getString(R.string.q3op1), getString(R.string.q3op2), getString(R.string.q3op3), getString(R.string.q3op4), new Answer(getString(R.string.q3op3)));
        Questions q4 = new Questions(getString(R.string.question4), getString(R.string.q4op1), getString(R.string.q4op2), getString(R.string.q4op3), getString(R.string.q4op4), new Answer(getString(R.string.q4op4)));
        Questions q5 = new Questions(getString(R.string.question5), getString(R.string.q5op1), getString(R.string.q5op2), getString(R.string.q5op3), getString(R.string.q5op4), new Answer(getString(R.string.q5op2)));
        Questions q7 = new Questions(getString(R.string.question7), getString(R.string.q7op1), getString(R.string.q7op2), getString(R.string.q7op3), getString(R.string.q7op4), new Answer(getString(R.string.q7op1)));
        Questions q8 = new Questions(getString(R.string.question8), getString(R.string.q8op1), getString(R.string.q8op2), getString(R.string.q8op3), getString(R.string.q8op4), new Answer(getString(R.string.q8op4)));
        Questions q9 = new Questions(getString(R.string.question9), getString(R.string.q9op1), getString(R.string.q9op2), getString(R.string.q9op3), getString(R.string.q9op4), new Answer(getString(R.string.q9op2)));

        Questions[] questionsArr = {q1, q3, q4, q5, q7, q8, q9};

        RadioGroup radioGroup[] = {radio_Q1, radio_Q3, radio_Q4, radio_Q5, radio_Q7, radio_Q8, radio_Q9};

        String answers[] = new String[7];
        for (RadioGroup r : radioGroup) {
            int selectedId = r.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = (RadioButton) findViewById(selectedId);
            answers[counter] = selectedRadioButton.getText().toString();
            counter++;
        }

        counter = 0;
        for (Questions q : questionsArr) {
            String ans = q.getAnswer1().getAnswer();
            if (ans.equals(answers[counter])) {
                correct++;
            } else {
                wrong++;
            }
            total++;
            counter++;
        }

        checkOptionOne = checkBoxOne.isChecked();
        checkOptionTwo = checkBoxTwo.isChecked();
        checkOptionThree = checkBoxThree.isChecked();
        checkOptionFour = checkBoxFour.isChecked();

        if (!checkOptionOne && checkOptionTwo && !checkOptionThree && checkOptionFour) {
            correct++;
        } else {
            wrong++;
        }
        total++;

        checkOptionFive = checkBoxFive.isChecked();
        checkOptionSix = checkBoxSix.isChecked();

        if (!checkOptionFive && checkOptionSix) {
            correct++;
        } else {
            wrong++;
        }
        total++;

        String questionTenAnswer = editText.getText().toString();

        if (questionTenAnswer.equals(getString(R.string.question_ten_answer))) {
            correct++;
        } else {
            wrong++;
        }
        total++;

    }


    public void submitAnswers(View view) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("Submit Answers")
                .setMessage("Are you sure you want to submit these answers?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        startQuiz();
                        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                        intent.putExtra("correct", correct);
                        intent.putExtra("wrong", wrong);
                        intent.putExtra("total", total);
                        startActivity(intent);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_info).show();
    }

    private int backButtonCount = 0;
    @Override
    public void onBackPressed(){
        if(backButtonCount >= 1)
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Press the back button once again to close the application.", Toast.LENGTH_SHORT).show();
            backButtonCount++;
        }
    }


}

