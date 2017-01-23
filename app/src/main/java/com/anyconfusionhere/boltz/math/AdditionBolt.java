package com.anyconfusionhere.boltz.math;

import android.text.SpannableStringBuilder;
import android.widget.TextView;

import com.anyconfusionhere.boltz.R;
import com.anyconfusionhere.boltz.Storm;
import com.anyconfusionhere.boltz.StormPresenter;
import com.anyconfusionhere.boltz.fragments.ComputationFragment;

public class AdditionBolt extends Bolt {

    public AdditionBolt(Storm storm) {
        super(storm);
        layoutResource = R.layout.activity_storm;
    }

    public SpannableStringBuilder produceQuestion() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int a = randomGenerator.nextInt(100) + 1;
        int b = randomGenerator.nextInt(100) + 1;
        int answer = a + b;
        spannableStringBuilder.append(Integer.toString(a) + "+" + Integer.toString(b) + " =");
        answertoReturn = String.valueOf(answer);
        return spannableStringBuilder;
    }
    @Override
    public SpannableStringBuilder presentQuestion(StormPresenter stormPresenter) {
        question = this.produceQuestion();
        stormPresenter.questionFrame.bringChildToFront(stormPresenter.simpleProblem);
        stormPresenter.inputFrame.bringChildToFront(stormPresenter.calcInput);
        ((TextView) stormPresenter.questionFrame.findViewById(R.id.currentProblem)).setText(question);
        return question;
    }


}
