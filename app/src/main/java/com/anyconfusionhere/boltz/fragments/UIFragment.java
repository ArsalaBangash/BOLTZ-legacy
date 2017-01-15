package com.anyconfusionhere.boltz.fragments;

import android.app.Fragment;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;

import com.anyconfusionhere.boltz.R;


public class UIFragment extends Fragment {
    TextView currentProblem;
    View problemView;

    public void setQuestion(SpannableStringBuilder newCurrentProblem) {
        this.currentProblem.setText(newCurrentProblem);
    }

    public TextView getAnswerView() {
        return (TextView) problemView.findViewById(R.id.currentAnswer);
    }
}
