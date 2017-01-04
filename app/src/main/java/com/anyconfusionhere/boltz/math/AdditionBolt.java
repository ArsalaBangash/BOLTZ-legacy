package com.anyconfusionhere.boltz.math;

import android.text.SpannableStringBuilder;

public class AdditionBolt extends Bolt {

    public SpannableStringBuilder produceQuestion() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int a = randomGenerator.nextInt(100) + 1;
        int b = randomGenerator.nextInt(100) + 1;
        int answer = a + b;
        spannableStringBuilder.append(Integer.toString(a) + "+" + Integer.toString(b) + " =");
        answertoReturn = String.valueOf(answer);
        return spannableStringBuilder;
    }
}
