package com.anyconfusionhere.boltz.math;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;

public class LogBolt extends Bolt {

    @Override
    public SpannableStringBuilder produceQuestion() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int b = randomGenerator.nextInt(10) + 3;
        int answer = randomGenerator.nextInt(exponentMap.get(b)) + 2;
        int a = ((int) Math.pow((double) b, (double) answer));
        spannableStringBuilder.append("log" + String.valueOf(b) + "(" + String.valueOf(a) + ")=");
        if (String.valueOf(b).length() == 1) {
            spannableStringBuilder.setSpan(new RelativeSizeSpan(0.35f), 3, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        } else if (String.valueOf(b).length() == 2) {
            spannableStringBuilder.setSpan(new RelativeSizeSpan(0.35f), 3, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        answertoReturn = String.valueOf(answer);
        return spannableStringBuilder;
    }
}
