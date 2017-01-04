package com.anyconfusionhere.boltz.math;

import android.text.SpannableStringBuilder;

import java.text.DecimalFormat;

public class DivisionBolt extends Bolt {
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
}