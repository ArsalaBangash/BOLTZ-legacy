package com.anyconfusionhere.boltz.math;

import android.text.SpannableStringBuilder;

import com.anyconfusionhere.boltz.R;
import com.anyconfusionhere.boltz.Storm;
import com.anyconfusionhere.boltz.StormPresenter;
import com.anyconfusionhere.boltz.fragments.ComputationFragment;

import java.text.DecimalFormat;

public class DivisionBolt extends Bolt {

    public DivisionBolt(Storm storm) {
        super(storm);
        layoutResource = R.layout.activity_storm;
    }

    @Override
    public SpannableStringBuilder produceQuestion() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int answer = randomGenerator.nextInt(12) + 1;
        int b = randomGenerator.nextInt(12) + 1;
        double c = answer * b;
        spannableStringBuilder.append(new DecimalFormat("#").format(c) + "\u00F7" + Integer.toString(b) + " =");
        answertoReturn = String.valueOf(answer);
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
