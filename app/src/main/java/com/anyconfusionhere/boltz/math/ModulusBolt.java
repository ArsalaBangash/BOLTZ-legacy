package com.anyconfusionhere.boltz.math;

import android.text.SpannableStringBuilder;

public class ModulusBolt extends Bolt {
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
}
