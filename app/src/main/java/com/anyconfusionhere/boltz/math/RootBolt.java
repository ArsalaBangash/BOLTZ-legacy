package com.anyconfusionhere.boltz.math;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.text.style.SuperscriptSpan;


public class RootBolt extends Bolt {

    @Override
    public SpannableStringBuilder produceQuestion() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int answer = randomGenerator.nextInt(10) + 3;
        int b = randomGenerator.nextInt(exponentMap.get(answer)) + 2;
        System.out.println(b);
        int a = (int) Math.pow((double)answer, (double)b);
        if(b == 2) {
            spannableStringBuilder.append("\u221A" + String.valueOf(a) + " =");
        } else {
            spannableStringBuilder.append(String.valueOf(b) + "\u221A" + String.valueOf(a) + " =");
            spannableStringBuilder.setSpan(new SuperscriptSpan(), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableStringBuilder.setSpan(new RelativeSizeSpan(0.5f), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        answertoReturn = String.valueOf(answer);
        return spannableStringBuilder;
    }
}