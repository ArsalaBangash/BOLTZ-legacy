package com.anyconfusionhere.boltz.math;

import android.text.SpannableStringBuilder;
import android.widget.TextView;

import com.anyconfusionhere.boltz.R;
import com.anyconfusionhere.boltz.Storm;
import com.anyconfusionhere.boltz.StormPresenter;
import com.anyconfusionhere.boltz.fragments.ComputationFragment;

import java.util.HashMap;
import java.util.Random;

public abstract class Bolt {
    HashMap<Integer, Integer> exponentMap;
    int layoutResource;
    TextView currentAnswer;
    SpannableStringBuilder question;

    public Bolt(Storm newStormActivity) {
        currentAnswer = (TextView) newStormActivity.stormPresenter.questionFrame.findViewById(R.id.currentAnswer);
        exponentMap = new HashMap<>();
        exponentMap.put(2, 5);
        exponentMap.put(3, 3);
        exponentMap.put(4, 2);
        exponentMap.put(5, 2);
        exponentMap.put(6, 2);
        exponentMap.put(7, 1);
        exponentMap.put(8, 1);
        exponentMap.put(9, 1);
        exponentMap.put(10, 2);
        exponentMap.put(11, 1);
        exponentMap.put(12, 1);
        exponentMap.put(13, 1);
    }

    static Random randomGenerator = new Random();
    String answertoReturn;

    public abstract SpannableStringBuilder produceQuestion();

    public String getAnswer() {
        return answertoReturn;
    }

    public int getLayoutResource() {
        return layoutResource;
    }

//    public abstract ComputationFragment getLayoutFragment();

    public String slice_end(String s, int endIndex) {
        if (endIndex < 0) endIndex = s.length() + endIndex;
        return s.substring(0, endIndex);
    }

    public void pull() {
        if (currentAnswer.length() > 0) {
            String newCurrentAnswer = slice_end(
                    currentAnswer.getText().toString(),
                    currentAnswer.getText().toString().length() - 1);
            currentAnswer.setText(newCurrentAnswer);
        }
    }

    public void push(String toPush) {
        if (currentAnswer.getText().toString().length() < 8) {
            currentAnswer.setText(currentAnswer.getText() + toPush);
        }
    }

    public abstract SpannableStringBuilder presentQuestion(StormPresenter stormPresenter);

    public Boolean check() {
        return answertoReturn.equals(String.valueOf(currentAnswer.getText()));
    }

    public void erase() {
        currentAnswer.setText("");
    }


}
