package com.anyconfusionhere.boltz.math;

import android.app.Fragment;
import android.text.SpannableStringBuilder;

import com.anyconfusionhere.boltz.R;
import com.anyconfusionhere.boltz.fragments.ClassicProblemFragment;

public class MultiplicationBolt extends Bolt {

    public MultiplicationBolt() {
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
    public ClassicProblemFragment getLayoutFragment() {
        return new ClassicProblemFragment();
    }
}
