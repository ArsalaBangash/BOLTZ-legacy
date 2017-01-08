package com.anyconfusionhere.boltz.math;

import android.app.Fragment;
import android.text.SpannableStringBuilder;

import com.anyconfusionhere.boltz.fragments.ClassicProblemFragment;

import java.util.HashMap;
import java.util.Random;

public abstract class Bolt {
    HashMap<Integer,Integer> exponentMap;
    int layoutResource;
    public Bolt() {
        exponentMap = new HashMap<>();
        exponentMap.put(2,5);
        exponentMap.put(3,3);
        exponentMap.put(4,2);
        exponentMap.put(5,2);
        exponentMap.put(6,2);
        exponentMap.put(7,1);
        exponentMap.put(8,1);
        exponentMap.put(9,1);
        exponentMap.put(10,2);
        exponentMap.put(11,1);
        exponentMap.put(12,1);
        exponentMap.put(13,1);
    }
    static Random randomGenerator = new Random();
    static String answertoReturn;
    public abstract SpannableStringBuilder produceQuestion();
    public String getAnswer(){return answertoReturn;}
    public int getLayoutResource(){return layoutResource;}
    public abstract ClassicProblemFragment getLayoutFragment();



}
