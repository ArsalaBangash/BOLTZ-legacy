package com.anyconfusionhere.boltz.math;

import android.text.SpannableStringBuilder;

import java.text.DecimalFormat;

public class DecimalSubtractionBolt extends Bolt {
    @Override
    public SpannableStringBuilder produceQuestion() {

        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        double c = Double.valueOf(new DecimalFormat("#.0").format(1 + (21 - 1) * randomGenerator.nextDouble()));
        double d = Double.valueOf(new DecimalFormat("#.0").format(1 + (21 - 1) * randomGenerator.nextDouble()));
        double dAnswer = Double.valueOf(new DecimalFormat("#.0").format(c - d));
        if (dAnswer == Math.floor(dAnswer)) {
            answertoReturn = new DecimalFormat("#").format(dAnswer);
        } else {
            answertoReturn = String.valueOf(dAnswer);
        }
        spannableStringBuilder.append(Double.toString(c) + "-" + Double.toString(d) + " =");
        return spannableStringBuilder;
    }
}
