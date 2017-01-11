package com.anyconfusionhere.boltz.math;

import android.text.SpannableStringBuilder;

import com.anyconfusionhere.boltz.R;
import com.anyconfusionhere.boltz.fragments.ComputationFragment;

public class ModulusBolt extends Bolt {

    public ModulusBolt() {
        layoutResource = R.layout.activity_storm;
    }

    @Override
    public SpannableStringBuilder produceQuestion() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int b = randomGenerator.nextInt(20) + 2;
        int a = b + randomGenerator.nextInt(20);
        int answer = a % b;
        spannableStringBuilder.append(Integer.toString(a) + "\uFF05" + Integer.toString(b) + " =");
        answertoReturn = String.valueOf(answer);
        return spannableStringBuilder;
    }

    @Override
    public ComputationFragment getLayoutFragment() {
        return new ComputationFragment();
    }
}
