package com.anyconfusionhere.boltz;


import android.app.Fragment;
import android.text.SpannableStringBuilder;

import com.anyconfusionhere.boltz.fragments.AlgebraInputFragment;
import com.anyconfusionhere.boltz.fragments.CalculatorInputFragment;
import com.anyconfusionhere.boltz.fragments.ComputationFragment;
import com.anyconfusionhere.boltz.fragments.FactorizationFragment;
import com.anyconfusionhere.boltz.fragments.UIFragment;
import com.anyconfusionhere.boltz.math.Bolt;

import java.util.Observable;
import java.util.Observer;

public class StormPresenter implements Observer {
    public SpannableStringBuilder question;
    private String answer;
    private Bolt bolt;
    public Storm storm;
    public UIFragment problemFragment, factorFragment;
    public Fragment inputFragment, algebraInputFragment;


    public StormPresenter(Storm stormActivity) {
        storm = stormActivity;
        problemFragment = new ComputationFragment();
        inputFragment = new CalculatorInputFragment();
        factorFragment = new FactorizationFragment();
        algebraInputFragment = new AlgebraInputFragment();

        storm.getFragmentManager().beginTransaction()
                .add(R.id.problemContainer, problemFragment)
                .commit();
        storm.getFragmentManager().beginTransaction()
                .add(R.id.input_container, inputFragment)
                .commit();
        storm.getFragmentManager().beginTransaction()
                .add(R.id.problemContainer, factorFragment)
                .commit();
        storm.getFragmentManager().beginTransaction()
                .add(R.id.input_container, algebraInputFragment)
                .commit();


    }

    public void presentQuestion() {
        question = bolt.presentQuestion(this);
        answer = bolt.getAnswer();

    }

    public boolean checkAnswer(String currentAnswer) {
        return answer.equals(currentAnswer);
    }

    public void pull() {
        bolt.pull();
    }

    public void push(String toPush) {
        bolt.push(toPush);
    }


    @Override
    public void update(Observable o, Object arg) {
        StormHandler stormHandler = (StormHandler) o;
        bolt = stormHandler.getBolt();
        presentQuestion();
    }
}
