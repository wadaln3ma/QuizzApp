package com.android.quizzapp;


public class Results implements IResult {
    private String message;

    // Using a switch would be a better choice.
    public void showResult(int correct, int wrong, int total) {
        int score = (correct * 100) / total;
        if (score == 100) {
            message = "Total Number Of Question: " + total
                    + "\nCorrect Answers: " + correct
                    + "\nWrong Answers: " + wrong
                    + "\nYour Score is: %" + score
                    + "\nCongratulations You Aced the Quiz";
        } else if (score >= 90) {
            message = "Total Number Of Question: " + total
                    + "\nCorrect Answers: " + correct
                    + "\nWrong Answers: " + wrong
                    + "\nYour Score is: %" + score
                    + "\nExcellent Work!";
        } else if (score >= 80) {
            message = "Total Number Of Question: " + total
                    + "\nCorrect Answers: " + correct
                    + "\nWrong Answers: " + wrong
                    + "\nYour Score is: %" + score
                    + "\nVery Good Work!";
        } else if (score >= 70) {
            message = "Total Number Of Question: " + total
                    + "\nCorrect Answers: " + correct
                    + "\nWrong Answers: " + wrong
                    + "\nYour Score is: %" + score
                    + "\nGood Work!";
        } else if (score >= 50) {
            message = "Total Number Of Question: " + total
                    + "\nCorrect Answers: " + correct
                    + "\nWrong Answers: " + wrong
                    + "\nYour Score is: %" + score
                    + "\nYou've passed!";
        } else if (score < 50 && !(score == 0)) {
            message = "Total Number Of Question: " + total
                    + "\nCorrect Answers: " + correct
                    + "\nWrong Answers: " + wrong
                    + "\nYour Score is: %" + score
                    + "\nYour Knowledge about Java is very poor you should work on that!";
        } else if (score == 0) {
            message = "Total Number Of Question: " + total
                    + "\nCorrect Answers: " + correct
                    + "\nWrong Answers: " + wrong
                    + "\nYour Grade is: %" + score
                    + "\noops! .. You Don't know anything about Java you should take a Udacity course about it";
        }
    }

    public  String getMessage() {
        return message;
    }
}
