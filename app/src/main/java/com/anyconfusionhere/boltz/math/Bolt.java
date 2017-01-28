package com.anyconfusionhere.boltz.math;

import android.text.SpannableStringBuilder;
import android.widget.TextView;

import com.anyconfusionhere.boltz.R;
import com.anyconfusionhere.boltz.Storm;
import com.anyconfusionhere.boltz.StormPresenter;

import java.util.HashMap;
import java.util.Random;

public abstract class Bolt {
    static Random randomGenerator = new Random();
    HashMap<Integer, Integer> exponentMap;
    SpannableStringBuilder question;
    String answertoReturn;
    private TextView currentAnswer;
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

    public abstract SpannableStringBuilder produceQuestion();

    /**
     * Returns the answer to the current Bolt
     *
     * @return The answer to the current Bolt
     */
    public String getAnswer() {
        return answertoReturn;
    }

    String slice_end(String s, int endIndex) {
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

    /**
     * Depending on it's type, this function will have a bolt bring it's requisite input and
     * question views to the front of the storm activity. This will allow Bolts to have user
     * interfaces suited to their mathematical needs. In addition to setting the necessary UI,
     * this function also returns the question to be presented by the Bolt.
     *
     * @param stormPresenter The Presenter which controls the storm activity
     * @return The question to be returned.
     */
    public abstract SpannableStringBuilder presentQuestion(StormPresenter stormPresenter);


    public Boolean check() {
        return answertoReturn.equals(String.valueOf(currentAnswer.getText()));
    }

    /**
     * Erases the user's current answer
     */
    public void erase() {
        currentAnswer.setText("");
    }


}
