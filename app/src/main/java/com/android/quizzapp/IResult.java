package com.android.quizzapp;


public interface IResult {
    String message = new String();
    void showResult(int correct, int wrong, int total);
    String getMessage();
}
