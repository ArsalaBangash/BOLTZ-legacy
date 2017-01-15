package com.anyconfusionhere.boltz.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anyconfusionhere.boltz.R;

public class ComputationFragment extends UIFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        problemView = inflater.inflate(R.layout.simple_problem, container, false);
        currentProblem = (TextView) problemView.findViewById(R.id.currentProblem);
        return problemView;
    }


}