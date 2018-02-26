package com.android.quizzapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {
    public TextView result;
    IResult res = new Results();
    int correct, wrong, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result = (TextView) findViewById(R.id.result);

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
}
