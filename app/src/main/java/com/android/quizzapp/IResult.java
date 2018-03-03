package com.android.quizzapp;


// Why do you need an interface?

public interface IResult {
//    String message = "";
    void showResult(int correct, int wrong, int total);
    String getMessage();
}
