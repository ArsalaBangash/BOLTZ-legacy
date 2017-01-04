package com.anyconfusionhere.boltz;


import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

public class StormPresenter implements Observer{
    private SpannableStringBuilder question;
    private String answer;
    private AppCompatActivity storm;
    TextView currentProblem;

    public StormPresenter(AppCompatActivity stormActivity){
        storm = stormActivity;

    }

    public void presentQuestion() {
        currentProblem = (TextView) storm.findViewById(R.id.currentProblem);
        currentProblem.setText(question);
    }

    public boolean checkAnswer(String currentAnswer) {
        return answer.equals(currentAnswer);
    }

    @Override
    public void update(Observable o, Object arg) {
        StormHandler stormHandler = (StormHandler) o;
        question = stormHandler.getQuestion();
        answer = stormHandler.getAnswer();
        presentQuestion();
    }
}
