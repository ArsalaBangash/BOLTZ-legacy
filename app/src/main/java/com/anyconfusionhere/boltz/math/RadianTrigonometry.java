package com.anyconfusionhere.boltz.math;

import android.text.SpannableStringBuilder;

import com.anyconfusionhere.boltz.R;
import com.anyconfusionhere.boltz.Storm;

import java.util.HashMap;
import java.util.Map;

public class RadianTrigonometry extends DegreeTrigonometry{
    Map<SpannableStringBuilder, String> radMap = new HashMap<>();


    public RadianTrigonometry(Storm newStormActivity) {
        super(newStormActivity);

        this.storm = newStormActivity;
        radMap.put(new SpannableStringBuilder("sin(0)"), "sin(0)");
        radMap.put(new SpannableStringBuilder("cos(0)"), "cos(0)");
        radMap.put(new SpannableStringBuilder("tan(0)"), "tan(0)");

        radMap.put(new SpannableStringBuilder("sin(30)"), "sin(\u03C0/6)");
        radMap.put(new SpannableStringBuilder("cos(30)"), "cos(\u03C0/6)");
        radMap.put(new SpannableStringBuilder("tan(30)"), "tan(\u03C0/6)");

        radMap.put(new SpannableStringBuilder("sin(45)"), "sin(\u03C0/4)");
        radMap.put(new SpannableStringBuilder("cos(45)"), "cos(\u03C0/4)");
        radMap.put(new SpannableStringBuilder("tan(45)"), "tan(\u03C0/4)");

        radMap.put(new SpannableStringBuilder("sin(60)"), "sin(\u03C0/3)");
        radMap.put(new SpannableStringBuilder("cos(60)"), "cos(\u03C0/3)");
        radMap.put(new SpannableStringBuilder("tan(60)"), "tan(\u03C0/3)");

        radMap.put(new SpannableStringBuilder("sin(90)"), "sin(\u03C0/2)");
        radMap.put(new SpannableStringBuilder("cos(90)"), "cos(\u03C0/2)");
        radMap.put(new SpannableStringBuilder("tan(90)"), "tan(\u03C0/2)");

        radMap.put(new SpannableStringBuilder("sin(120)"), "sin(2\u03C0/3)");
        radMap.put(new SpannableStringBuilder("cos(120)"), "cos(2\u03C0/3)");
        radMap.put(new SpannableStringBuilder("tan(120)"), "tan(2\u03C0/3)");

        radMap.put(new SpannableStringBuilder("sin(135)"), "sin(3\u03C0/4)");
        radMap.put(new SpannableStringBuilder("cos(135)"), "cos(3\u03C0/4)");
        radMap.put(new SpannableStringBuilder("tan(135)"), "tan(3\u03C0/4)");

        radMap.put(new SpannableStringBuilder("sin(150)"), "sin(5\u03C0/6)");
        radMap.put(new SpannableStringBuilder("cos(150)"), "cos(5\u03C0/6)");
        radMap.put(new SpannableStringBuilder("tan(150)"), "tan(5\u03C0/6)");

        radMap.put(new SpannableStringBuilder("sin(180)"), "sin(\u03C0)");
        radMap.put(new SpannableStringBuilder("cos(180)"), "cos(\u03C0)");
        radMap.put(new SpannableStringBuilder("tan(180)"), "tan(\u03C0)");

        radMap.put(new SpannableStringBuilder("sin(210)"), "sin(7\u03C0/6)");
        radMap.put(new SpannableStringBuilder("cos(210)"), "cos(7\u03C0/6)");
        radMap.put(new SpannableStringBuilder("tan(210)"), "tan(7\u03C0/6)");

        radMap.put(new SpannableStringBuilder("sin(225)"), "sin(5\u03C0/4)");
        radMap.put(new SpannableStringBuilder("cos(225)"), "cos(5\u03C0/4)");
        radMap.put(new SpannableStringBuilder("tan(225)"), "tan(5\u03C0/4)");

        radMap.put(new SpannableStringBuilder("sin(240)"), "sin(4\u03C0/3)");
        radMap.put(new SpannableStringBuilder("cos(240)"), "cos(4\u03C0/3)");
        radMap.put(new SpannableStringBuilder("tan(240)"), "tan(4\u03C0/3)");

        radMap.put(new SpannableStringBuilder("sin(270)"), "sin(3\u03C0/2)");
        radMap.put(new SpannableStringBuilder("cos(270)"), "cos(3\u03C0/2)");
        radMap.put(new SpannableStringBuilder("tan(270)"), "tan(3\u03C0/2)");

        radMap.put(new SpannableStringBuilder("sin(300)"), "sin(5\u03C0/3)");
        radMap.put(new SpannableStringBuilder("cos(300)"), "cos(5\u03C0/3)");
        radMap.put(new SpannableStringBuilder("tan(300)"), "tan(5\u03C0/3)");

        radMap.put(new SpannableStringBuilder("sin(315)"), "sin(7\u03C0/4)");
        radMap.put(new SpannableStringBuilder("cos(315)"), "cos(7\u03C0/4)");
        radMap.put(new SpannableStringBuilder("tan(315)"), "tan(7\u03C0/4)");

        radMap.put(new SpannableStringBuilder("sin(330)"), "sin(11\u03C0/6)");
        radMap.put(new SpannableStringBuilder("cos(330)"), "cos(11\u03C0/6)");
        radMap.put(new SpannableStringBuilder("tan(330)"), "tan(11\u03C0/6)");

    }

    @Override
    public SpannableStringBuilder produceQuestion() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int trigOperator = randomGenerator.nextInt(3);
        int degreeChooser = randomGenerator.nextInt(3) + 2;
        int baseChooser = randomGenerator.nextInt(4);
        int base = 90 * baseChooser;
        int degrees = base + (15 * degreeChooser);
        if (trigOperator == 0) {
            spannableStringBuilder.append("sin(" + degrees + ")");
        } else if (trigOperator == 1) {
            spannableStringBuilder.append("cos(" + degrees + ")");
        } else if (trigOperator == 2) {
            spannableStringBuilder.append("tan(" + degrees + ")");
        }
        answertoReturn = trigMap.get(spannableStringBuilder);
        multipleChoiceQuestions.add(answertoReturn);
        for (String value: trigMap.values()) {
            if (!(multipleChoiceQuestions.size() == 4)) {
                if (!value.equals(answertoReturn)) {
                    multipleChoiceQuestions.add(value);
                }
            }

        }
        return SpannableStringBuilder.valueOf(radMap.get(spannableStringBuilder));
    }
}
