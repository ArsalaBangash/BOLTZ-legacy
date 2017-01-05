package com.anyconfusionhere.boltz.math;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.text.style.SuperscriptSpan;

import com.anyconfusionhere.boltz.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FactorizationBolt extends Bolt{

    public FactorizationBolt() {
        layoutResource = R.layout.activity_factorisation_bolt;
    }

    String answer1, answer2;
    @Override
    public SpannableStringBuilder produceQuestion() {
        int number1 = randomGenerator.nextInt(9) + 1;
        int number2 = randomGenerator.nextInt(9) + 1;
        int operator1 = randomGenerator.nextInt(2);
        int operator2 = randomGenerator.nextInt(2);
        int xFirst1 = randomGenerator.nextInt(2);
        int xFirst2 = randomGenerator.nextInt(2);
        answer1 = "";
        answer2 = "";
        int[] answer1Array = new int[2];
        int[] answer2Array = new int[2];
        if (xFirst1 == 0) {
            answer1Array[0] = 1000;
            if (operator1 == 0) {
                answer1Array[1] = number1;
            } else if (operator1 == 1) {
                answer1Array[1] = (-1*number1);
            }
        } else if (xFirst1 == 1) {
            answer1Array[0] = number1;
            if (operator1 == 0) {
                answer1Array[1] = 1000;
            } else if (operator1 == 1) {
                answer1Array[1] = -1000;
            }
        }

        if (xFirst2 == 0) {
            answer2Array[0] = 1000;
            if (operator2 == 0) {
                answer2Array[1] = number2;
            } else if (operator2 == 1) {
                answer2Array[1] = (-1*number2);
            }
        } else if (xFirst2 == 1) {
            answer2Array[0] = number2;
            if (operator2 == 0) {
                answer2Array[1] = 1000;
            } else if (operator2 == 1) {
                answer2Array[1] = -1000;
            }
        }
        ArrayList<String> quadArray = parseArrayFactors(answer1Array,answer2Array);

        String parsedAnswer = getParsedAnswer(quadArray);
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
        Integer squaredCoeff = Integer.parseInt(quadArray.get(0));
        Integer xCoeff = (Integer.parseInt(quadArray.get(1)) + Integer.parseInt(quadArray.get(2))) / 1000;
        Integer constant = Integer.parseInt(quadArray.get(3));

        if ( squaredCoeff > 0) {
            stringBuilder.append("x2 ");
        } else {
            stringBuilder.append("-x2 ");
        }

        if (xCoeff > 0) {
            stringBuilder.append("+ " + xCoeff + "x ");
        } else if (xCoeff < 0){
            stringBuilder.append("- " + (-1*xCoeff) + "x ");
        }

        if (constant > 0) {
            stringBuilder.append("+ " + constant);
        } else {
            stringBuilder.append("- " + (-1*constant));
        }

        if (String.valueOf(stringBuilder.charAt(0)).equals("-")) {
            stringBuilder.setSpan(new SuperscriptSpan(), 2, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            stringBuilder.setSpan(new RelativeSizeSpan(0.75f), 2, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        } else {
            stringBuilder.setSpan(new SuperscriptSpan(), 1, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            stringBuilder.setSpan(new RelativeSizeSpan(0.75f), 1, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return stringBuilder;
    }

    public String getParsedAnswer(ArrayList<String> parsedArray) {
        String parsed = "";
        for (int i = 0; i<parsedArray.size(); i++) {
            parsed += parsedArray.get(i);
            parsed += ",,";
        }
        return parsed;
    }

    public ArrayList<String> parseArrayFactors(int[] answer1Array, int[] answer2Array) {
        ArrayList<String> quadArray = new ArrayList<String>();
        quadArray.add(String.valueOf(answer1Array[0] * answer2Array[0]));
        quadArray.add(String.valueOf(answer1Array[0] * answer2Array[1]));
        quadArray.add(String.valueOf(answer1Array[1] * answer2Array[0]));
        quadArray.add(String.valueOf(answer1Array[1] * answer2Array[1]));
        Collections.sort(quadArray, new Comparator<String>()
        {
            public int compare(String s1,String s2)
            {
                return s2.length() - s1.length();
            }
        });
        return quadArray;
    }

    public int[] parseStringFactors(String factorString) {
        int[] stringFactorArray = new int[2];
        try {
            if (String.valueOf(factorString.charAt(0)).equals("x")) {
                stringFactorArray[0] = 1000;
            } else {
                stringFactorArray[0] = Integer.parseInt(String.valueOf(factorString.charAt(0)));
            }
            if (String.valueOf(factorString.charAt(1)).equals("+")) {
                if (String.valueOf(factorString.charAt(2)).equals("x")) {
                    stringFactorArray[1] = 1000;
                } else {
                    stringFactorArray[1] = Integer.parseInt(String.valueOf(factorString.charAt(2)));

                }
            } else {
                if (String.valueOf(factorString.charAt(2)).equals("x")) {
                    stringFactorArray[1] = -1000;
                } else {
                    stringFactorArray[1] = -1 * Integer.parseInt(String.valueOf(factorString.charAt(2)));
                }
            }
        } catch (NumberFormatException e) {
            stringFactorArray[0] = -1;
            stringFactorArray[1] = -1;
        }
        return stringFactorArray;

    }
}
