package com.android.quizzapp;

public interface IResult {
    void showResult(int correct, int wrong, int total);
    String getMessage();
}
