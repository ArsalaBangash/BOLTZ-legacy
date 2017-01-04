package com.anyconfusionhere.boltz.math;

import android.text.SpannableStringBuilder;

public class MultiplicationBolt extends Bolt {
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
}
