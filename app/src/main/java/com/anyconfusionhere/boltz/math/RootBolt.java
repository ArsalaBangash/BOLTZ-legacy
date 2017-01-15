package com.anyconfusionhere.boltz.math;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.text.style.SuperscriptSpan;

import com.anyconfusionhere.boltz.R;
import com.anyconfusionhere.boltz.Storm;
import com.anyconfusionhere.boltz.StormPresenter;
import com.anyconfusionhere.boltz.fragments.ComputationFragment;


public class RootBolt extends Bolt {

    public RootBolt(Storm storm) {
        super(storm);
        layoutResource = R.layout.activity_storm;
    }

    @Override
    public SpannableStringBuilder produceQuestion() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int answer = randomGenerator.nextInt(10) + 3;
        int b = randomGenerator.nextInt(exponentMap.get(answer)) + 2;
        System.out.println(b);
        int a = (int) Math.pow((double) answer, (double) b);
        if (b == 2) {
            spannableStringBuilder.append("\u221A" + String.valueOf(a) + " =");
        } else {
            spannableStringBuilder.append(String.valueOf(b) + "\u221A" + String.valueOf(a) + " =");
            spannableStringBuilder.setSpan(new SuperscriptSpan(), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableStringBuilder.setSpan(new RelativeSizeSpan(0.5f), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
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
