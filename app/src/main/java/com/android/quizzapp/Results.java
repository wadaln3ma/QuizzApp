package com.android.quizzapp;


public class Results implements IResult {
    public String message;

    public void showResult(int correct, int wrong, int total) {
        int grade = (correct * 100) / total;
        if (grade == 100) {
            message = "Total Number Of Question: " + total
                    + "\nCorrect Answers: " + correct
                    + "\nWrong Answers: " + wrong
                    + "\nYour Grade is: %" + grade
                    + "\nCongratulations You Aced the Quiz";
        } else if (grade >= 90) {
            message = "Total Number Of Question: " + total
                    + "\nCorrect Answers: " + correct
                    + "\nWrong Answers: " + wrong
                    + "\nYour Grade is: %" + grade
                    + "\nExcellent Work!";
        } else if (grade >= 80) {
            message = "Total Number Of Question: " + total
                    + "\nCorrect Answers: " + correct
                    + "\nWrong Answers: " + wrong
                    + "\nYour Grade is: %" + grade
                    + "\nVery Good Work!";
        } else if (grade >= 70) {
            message = "Total Number Of Question: " + total
                    + "\nCorrect Answers: " + correct
                    + "\nWrong Answers: " + wrong
                    + "\nYour Grade is: %" + grade
                    + "\nGood Work!";
        } else if (grade >= 50) {
            message = "Total Number Of Question: " + total
                    + "\nCorrect Answers: " + correct
                    + "\nWrong Answers: " + wrong
                    + "\nYour Grade is: %" + grade
                    + "\nYou've Just barely passed!";
        } else if (grade < 50 && !(grade == 0)) {
            message = "Total Number Of Question: " + total
                    + "\nCorrect Answers: " + correct
                    + "\nWrong Answers: " + wrong
                    + "\nYour Grade is: %" + grade
                    + "\nYour Knowledge about Java is very poor you should work on that!";
        } else if (grade == 0) {
            message = "Total Number Of Question: " + total
                    + "\nCorrect Answers: " + correct
                    + "\nWrong Answers: " + wrong
                    + "\nYour Grade is: %" + grade
                    + "\noops! .. You Don't know anything about Java you should take a Udacity course about it";
        }
    }

    public  String getMessage() {
        return message;
    }
}
