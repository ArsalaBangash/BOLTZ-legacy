package com.anyconfusionhere.boltz.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.anyconfusionhere.boltz.R;

public class ComputationFragment extends Fragment {
    TextView currentProblem;
    View problemView;
    private static ComputationFragment computationFragmentInstance = new ComputationFragment();

    public static ComputationFragment getComputationFragmentInstance(){
        return computationFragmentInstance;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        problemView =  inflater.inflate(R.layout.simple_question_fragment, container, false);
        currentProblem = (TextView) problemView.findViewById(R.id.currentProblem);
        return problemView;
    }
    public void setQuestion(SpannableStringBuilder newCurrentProblem) {
        currentProblem.setText(newCurrentProblem);
    }

    public TextView getAnswerView() {
        return (TextView) problemView.findViewById(R.id.currentAnswer);
    }
}
