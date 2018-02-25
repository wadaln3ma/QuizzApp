package com.android.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {
    public TextView result;
    IResult res = new Results();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result = (TextView) findViewById(R.id.result);
        res.showResult(MainActivity.correct, MainActivity.wrong, MainActivity.total);
        String msg = res.getMessage();
        result.setText(msg);
    }
}
