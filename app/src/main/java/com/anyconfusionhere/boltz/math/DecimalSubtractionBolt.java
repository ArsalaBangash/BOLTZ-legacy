package com.anyconfusionhere.boltz.math;

import android.text.SpannableStringBuilder;
import android.widget.TextView;

import com.anyconfusionhere.boltz.R;
import com.anyconfusionhere.boltz.Storm;
import com.anyconfusionhere.boltz.StormPresenter;
import com.anyconfusionhere.boltz.fragments.ComputationFragment;

import java.text.DecimalFormat;

public class DecimalSubtractionBolt extends Bolt {

    public DecimalSubtractionBolt(Storm storm) {
        super(storm);
        layoutResource = R.layout.activity_storm;
    }

    @Override
    public SpannableStringBuilder produceQuestion() {

        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        double c = Double.valueOf(new DecimalFormat("#.0").format(1 + (21 - 1) * randomGenerator.nextDouble()));
        double d = Double.valueOf(new DecimalFormat("#.0").format(1 + (21 - 1) * randomGenerator.nextDouble()));
        double dAnswer = Double.valueOf(new DecimalFormat("#.0").format(c - d));
        if (dAnswer == Math.floor(dAnswer)) {
            answertoReturn = new DecimalFormat("#").format(dAnswer);
        } else {
            answertoReturn = String.valueOf(dAnswer);
        }
        spannableStringBuilder.append(Double.toString(c) + "-" + Double.toString(d) + " =");
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
