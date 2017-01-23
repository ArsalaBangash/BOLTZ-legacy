package com.anyconfusionhere.boltz.math;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.text.style.SuperscriptSpan;
import android.widget.TextView;

import com.anyconfusionhere.boltz.R;
import com.anyconfusionhere.boltz.Storm;
import com.anyconfusionhere.boltz.StormPresenter;
import com.anyconfusionhere.boltz.fragments.ComputationFragment;


public class ExponentBolt extends Bolt {

    public ExponentBolt(Storm storm) {
        super(storm);
        layoutResource = R.layout.activity_storm;
    }

    @Override
    public SpannableStringBuilder produceQuestion() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int a = randomGenerator.nextInt(10) + 3;
        int b = randomGenerator.nextInt(exponentMap.get(a)) + 2;
        int answer = ((int) Math.pow((double) a, (double) b));
        spannableStringBuilder.append(String.valueOf(a) + String.valueOf(b) + " =");
        if (spannableStringBuilder.length() == 4) {
            spannableStringBuilder.setSpan(new SuperscriptSpan(), 1, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableStringBuilder.setSpan(new RelativeSizeSpan(0.75f), 1, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        if (spannableStringBuilder.length() == 5) {
            if (a - 10 >= 0) {
                spannableStringBuilder.setSpan(new SuperscriptSpan(), 2, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                spannableStringBuilder.setSpan(new RelativeSizeSpan(0.75f), 2, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else {
                spannableStringBuilder.setSpan(new SuperscriptSpan(), 1, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                spannableStringBuilder.setSpan(new RelativeSizeSpan(0.75f), 1, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        answertoReturn = String.valueOf(answer);
        return spannableStringBuilder;
    }
    @Override
    public SpannableStringBuilder presentQuestion(StormPresenter stormPresenter) {
        question = this.produceQuestion();
        stormPresenter.questionFrame.bringChildToFront(stormPresenter.simpleProblem);
        stormPresenter.inputFrame.bringChildToFront(stormPresenter.calcInput);
        ((TextView) stormPresenter.questionFrame.findViewById(R.id.currentProblem)).setText(question);
        return question;
    }
}
