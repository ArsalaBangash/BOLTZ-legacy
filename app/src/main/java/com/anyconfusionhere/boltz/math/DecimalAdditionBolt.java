package com.anyconfusionhere.boltz.math;

import android.text.SpannableStringBuilder;

import com.anyconfusionhere.boltz.R;
import com.anyconfusionhere.boltz.Storm;
import com.anyconfusionhere.boltz.StormPresenter;
import com.anyconfusionhere.boltz.fragments.ComputationFragment;

import java.text.DecimalFormat;

public class DecimalAdditionBolt extends Bolt {

    public DecimalAdditionBolt(Storm storm) {
        super(storm);
        layoutResource = R.layout.activity_storm;
    }

    @Override
    public SpannableStringBuilder produceQuestion() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        double c = Double.valueOf(new DecimalFormat("#.0").format(1 + (21 - 1) * randomGenerator.nextDouble()));
        double d = Double.valueOf(new DecimalFormat("#.0").format(1 + (21 - 1) * randomGenerator.nextDouble()));
        double dAnswer = Double.valueOf(new DecimalFormat("#.0").format(c + d));
        if (dAnswer == Math.floor(dAnswer)) {
            answertoReturn = new DecimalFormat("#").format(dAnswer);
        } else {
            answertoReturn = String.valueOf(dAnswer);
        }
        spannableStringBuilder.append(Double.toString(c) + "+" + Double.toString(d) + " =");
        return spannableStringBuilder;
    }

    @Override
    public ComputationFragment getLayoutFragment() {
        return new ComputationFragment();
    }


    @Override
    public SpannableStringBuilder presentQuestion(StormPresenter stormPresenter) {
        stormPresenter.storm.getFragmentManager().beginTransaction()
                .replace(R.id.problemContainer, stormPresenter.problemFragment)
                .commit();
        stormPresenter.storm.getFragmentManager().beginTransaction()
                .replace(R.id.input_container, stormPresenter.inputFragment)
                .commit();
        question = this.produceQuestion();
        stormPresenter.problemFragment.setQuestion(question);
        return question;
    }
}
