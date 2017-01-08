package com.anyconfusionhere.boltz;


import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

import com.anyconfusionhere.boltz.fragments.ClassicProblemFragment;

public class StormPresenter implements Observer{
    public SpannableStringBuilder question;
    private String answer;
    private AppCompatActivity storm;
    public ClassicProblemFragment problemFragment;

    public StormPresenter(AppCompatActivity stormActivity){
        storm = stormActivity;
        problemFragment = new ClassicProblemFragment();
        storm.getFragmentManager().beginTransaction()
                .add(R.id.problemContainer, problemFragment)
                .commit();
    }

    public void presentQuestion() {
        problemFragment.setQuestion(question);
    }

    public boolean checkAnswer(String currentAnswer) {
        return answer.equals(currentAnswer);
    }

    @Override
    public void update(Observable o, Object arg) {
        StormHandler stormHandler = (StormHandler) o;
        question = stormHandler.getQuestion();
        answer = stormHandler.getAnswer();
//        f = stormHandler.getLayoutFragment();
        presentQuestion();
    }
}
