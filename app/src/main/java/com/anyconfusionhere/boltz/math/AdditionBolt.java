package com.anyconfusionhere.boltz.math;

import android.app.Fragment;
import android.text.SpannableStringBuilder;

import com.anyconfusionhere.boltz.R;
import com.anyconfusionhere.boltz.fragments.ClassicProblemFragment;

public class AdditionBolt extends Bolt {

    public AdditionBolt() {
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
    public ClassicProblemFragment getLayoutFragment() {
        return new ClassicProblemFragment();
    }
}
