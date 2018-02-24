package com.android.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.android.quizzapp.MainActivity.correct;
import static com.android.quizzapp.MainActivity.total;
import static com.android.quizzapp.MainActivity.wrong;

public class ResultActivity extends AppCompatActivity {

    public TextView result;
    Results res = new Results();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result = (TextView) findViewById(R.id.result);
        res.showResult(correct, wrong, total);
        result.setText(res.message);
    }
}
