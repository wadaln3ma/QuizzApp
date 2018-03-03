package com.android.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {
    public TextView result;
    IResult res = new Results();
    int correct, wrong, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result = findViewById(R.id.result);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            correct = extras.getInt("correct");
            wrong = extras.getInt("wrong");
            total = extras.getInt("total");
        }

        res.showResult(correct, wrong, total);
        String msg = res.getMessage();
        result.setText(msg);
    }

    // you're stacking on the previous views.  You should be releasing not adding more.
    // Also when you refactor this, you won't need to use any putExtra's
    public void restartQuiz(View view) {
        Intent intent = new Intent(ResultActivity.this, QuizActivity.class);
        intent.putExtra("correct", 0);
        intent.putExtra("wrong", 0);
        intent.putExtra("total", 0);
        startActivity(intent);
    }

    // If you're not going to over ride this, you're better commenting this out.
    @Override
    public void onBackPressed(){
        //do nothing
    }

}