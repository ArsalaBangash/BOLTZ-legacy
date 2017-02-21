package com.anyconfusionhere.boltz.math;

import android.text.SpannableStringBuilder;
import android.widget.TextView;

import com.anyconfusionhere.boltz.R;
import com.anyconfusionhere.boltz.Storm;
import com.anyconfusionhere.boltz.StormPresenter;

public class DecimalToBinaryBolt extends Bolt{
    int numWhiteSpaces;

    public DecimalToBinaryBolt(Storm newStormActivity) {
        super(newStormActivity);
        currentAnswer = (TextView) newStormActivity.stormPresenter.questionFrame.findViewById(R.id.binAnswer);
    }

    @Override
    public SpannableStringBuilder produceQuestion() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int a = randomGenerator.nextInt(129);
        spannableStringBuilder.append(String.valueOf(a));
        String binaryString = Integer.toBinaryString(a);
        numWhiteSpaces = 8 - binaryString.length();
        answertoReturn = "";
        for (int i =0;i<numWhiteSpaces;i++) {
            answertoReturn += " ";
        }
        currentAnswer.setText(answertoReturn);
        answertoReturn += binaryString;
        return spannableStringBuilder;
    }

    @Override
    public void pull() {
        if (currentAnswer.length() > numWhiteSpaces) {
            String newCurrentAnswer = slice_end(
                    currentAnswer.getText().toString(),
                    currentAnswer.getText().toString().length() - 1);
            currentAnswer.setText(newCurrentAnswer);
        }
    }

    @Override
    public SpannableStringBuilder presentQuestion(StormPresenter stormPresenter) {
        question = this.produceQuestion();
        stormPresenter.questionFrame.bringChildToFront(stormPresenter.decimalToBinaryProblem);
        stormPresenter.inputFrame.bringChildToFront(stormPresenter.binaryInput);
        ((TextView) stormPresenter.questionFrame.findViewById(R.id.binProblem)).setText(question);
        return question;
    }

    @Override
    public void erase() {
        String temp = "";
        for (int i =0;i<numWhiteSpaces;i++) {
            temp += " ";
        }
        currentAnswer.setText(temp);
    }
}
