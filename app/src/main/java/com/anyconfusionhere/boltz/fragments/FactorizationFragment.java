package com.anyconfusionhere.boltz.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anyconfusionhere.boltz.R;

public class FactorizationFragment extends UIFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        problemView = inflater.inflate(R.layout.factorisation_problem, container, false);
        currentProblem = (TextView) problemView.findViewById(R.id.factorProblem);
        return problemView;
    }

}
