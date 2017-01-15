package com.anyconfusionhere.boltz.math;

import android.text.SpannableStringBuilder;

import com.anyconfusionhere.boltz.R;
import com.anyconfusionhere.boltz.Storm;
import com.anyconfusionhere.boltz.StormPresenter;
import com.anyconfusionhere.boltz.fragments.ComputationFragment;

public class MultiplicationBolt extends Bolt {

    public MultiplicationBolt(Storm storm) {
        super(storm);
        layoutResource = R.layout.activity_storm;
    }

    @Override
    public SpannableStringBuilder produceQuestion() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int a = randomGenerator.nextInt(12) + 2;
        int b = randomGenerator.nextInt(12) + 2;
        int answer = a * b;
        spannableStringBuilder.append(Integer.toString(a) + "*" + Integer.toString(b) + " =");
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
