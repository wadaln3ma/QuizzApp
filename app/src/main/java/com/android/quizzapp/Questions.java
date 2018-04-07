package com.android.quizzapp;


public class Questions {

    // these should be private
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private Answer answer;

    public Questions(String question, String option1, String option2, String option3, String option4, Answer answer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
    }

    public Answer getAnswer1() {
        return answer;
    }
}
