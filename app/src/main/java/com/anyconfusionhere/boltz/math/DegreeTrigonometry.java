package com.anyconfusionhere.boltz.math;

import android.text.Html;
import android.text.SpannableStringBuilder;
import android.widget.Button;
import android.widget.TextView;

import com.anyconfusionhere.boltz.R;
import com.anyconfusionhere.boltz.Storm;
import com.anyconfusionhere.boltz.StormPresenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeTrigonometry extends Bolt{
    List<String> multipleChoiceQuestions = new ArrayList<>();
    Storm storm;
    Map<SpannableStringBuilder, String> trigMap = new HashMap<>();


    public DegreeTrigonometry(Storm newStormActivity) {
        super(newStormActivity);
        this.storm = newStormActivity;
        trigMap.put(new SpannableStringBuilder("sin(0)"), newStormActivity.getString(R.string.Zero));
        trigMap.put(new SpannableStringBuilder("cos(0)"), newStormActivity.getString(R.string.One));
        trigMap.put(new SpannableStringBuilder("tan(0)"), newStormActivity.getString(R.string.Zero));

        trigMap.put(new SpannableStringBuilder("sin(30)"), newStormActivity.getString(R.string.Half));
        trigMap.put(new SpannableStringBuilder("cos(30)"), newStormActivity.getString(R.string.Root3By2));
        trigMap.put(new SpannableStringBuilder("tan(30)"), newStormActivity.getString(R.string.OneByRoot3));

        trigMap.put(new SpannableStringBuilder("sin(45)"), newStormActivity.getString(R.string.Root2By2));
        trigMap.put(new SpannableStringBuilder("cos(45)"), newStormActivity.getString(R.string.Root2By2));
        trigMap.put(new SpannableStringBuilder("tan(45)"), newStormActivity.getString(R.string.One));

        trigMap.put(new SpannableStringBuilder("sin(60)"), newStormActivity.getString(R.string.Root3By2));
        trigMap.put(new SpannableStringBuilder("cos(60)"), newStormActivity.getString(R.string.Half));
        trigMap.put(new SpannableStringBuilder("tan(60)"), newStormActivity.getString(R.string.Root3));

        trigMap.put(new SpannableStringBuilder("sin(90)"), newStormActivity.getString(R.string.One));
        trigMap.put(new SpannableStringBuilder("cos(90)"), newStormActivity.getString(R.string.Zero));
        trigMap.put(new SpannableStringBuilder("tan(90)"), newStormActivity.getString(R.string.Undefined));

        trigMap.put(new SpannableStringBuilder("sin(120)"), newStormActivity.getString(R.string.Root3By2));
        trigMap.put(new SpannableStringBuilder("cos(120)"), newStormActivity.getString(R.string.NegHalf));
        trigMap.put(new SpannableStringBuilder("tan(120)"), newStormActivity.getString(R.string.NegRoot3));

        trigMap.put(new SpannableStringBuilder("sin(135)"), newStormActivity.getString(R.string.Root2By2));
        trigMap.put(new SpannableStringBuilder("cos(135)"), newStormActivity.getString(R.string.NegRoot2By2));
        trigMap.put(new SpannableStringBuilder("tan(135)"), newStormActivity.getString(R.string.NegOne));

        trigMap.put(new SpannableStringBuilder("sin(150)"), newStormActivity.getString(R.string.Half));
        trigMap.put(new SpannableStringBuilder("cos(150)"), newStormActivity.getString(R.string.NegRoot3By2));
        trigMap.put(new SpannableStringBuilder("tan(150)"), newStormActivity.getString(R.string.NegOneByRoot3));

        trigMap.put(new SpannableStringBuilder("sin(180)"), newStormActivity.getString(R.string.Zero));
        trigMap.put(new SpannableStringBuilder("cos(180)"), newStormActivity.getString(R.string.NegOne));
        trigMap.put(new SpannableStringBuilder("tan(180)"), newStormActivity.getString(R.string.Zero));

        trigMap.put(new SpannableStringBuilder("sin(210)"), newStormActivity.getString(R.string.NegHalf));
        trigMap.put(new SpannableStringBuilder("cos(210)"), newStormActivity.getString(R.string.NegRoot3By2));
        trigMap.put(new SpannableStringBuilder("tan(210)"), newStormActivity.getString(R.string.OneByRoot3));

        trigMap.put(new SpannableStringBuilder("sin(225)"), newStormActivity.getString(R.string.NegRoot2By2));
        trigMap.put(new SpannableStringBuilder("cos(225)"), newStormActivity.getString(R.string.NegRoot2By2));
        trigMap.put(new SpannableStringBuilder("tan(225)"), newStormActivity.getString(R.string.One));

        trigMap.put(new SpannableStringBuilder("sin(240)"), newStormActivity.getString(R.string.NegRoot3By2));
        trigMap.put(new SpannableStringBuilder("cos(240)"), newStormActivity.getString(R.string.NegHalf));
        trigMap.put(new SpannableStringBuilder("tan(240)"), newStormActivity.getString(R.string.Root3));

        trigMap.put(new SpannableStringBuilder("sin(270)"), newStormActivity.getString(R.string.NegOne));
        trigMap.put(new SpannableStringBuilder("cos(270)"), newStormActivity.getString(R.string.Zero));
        trigMap.put(new SpannableStringBuilder("tan(270)"), newStormActivity.getString(R.string.Undefined));

        trigMap.put(new SpannableStringBuilder("sin(300)"), newStormActivity.getString(R.string.NegRoot3By2));
        trigMap.put(new SpannableStringBuilder("cos(300)"), newStormActivity.getString(R.string.Half));
        trigMap.put(new SpannableStringBuilder("tan(300)"), newStormActivity.getString(R.string.NegRoot3));

        trigMap.put(new SpannableStringBuilder("sin(315)"), newStormActivity.getString(R.string.NegRoot2By2));
        trigMap.put(new SpannableStringBuilder("cos(315)"), newStormActivity.getString(R.string.Root2By2));
        trigMap.put(new SpannableStringBuilder("tan(315)"), newStormActivity.getString(R.string.NegOne));

        trigMap.put(new SpannableStringBuilder("sin(330)"), newStormActivity.getString(R.string.NegHalf));
        trigMap.put(new SpannableStringBuilder("cos(330)"), newStormActivity.getString(R.string.NegRoot3By2));
        trigMap.put(new SpannableStringBuilder("tan(330)"), newStormActivity.getString(R.string.NegOneByRoot3));




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

        return spannableStringBuilder;
    }

    @Override
    public void push(String toPush) {
    }

    @Override
    public Boolean check(String multipleChoiceTag) {
        return ((Button)this.storm.stormPresenter.multipleChoiceInput.findViewWithTag(multipleChoiceTag))
                .getText().toString().equals(answertoReturn);
    }

    @Override
    public SpannableStringBuilder presentQuestion(StormPresenter stormPresenter) {
        question = this.produceQuestion();
        Collections.shuffle(multipleChoiceQuestions);
        stormPresenter.questionFrame.bringChildToFront(stormPresenter.simpleProblem);
        stormPresenter.inputFrame.bringChildToFront(stormPresenter.multipleChoiceInput);
        ((Button) stormPresenter.multipleChoiceInput.findViewById(R.id.optionA))
                .setText(Html.fromHtml(multipleChoiceQuestions.get(0)));
        ((Button) stormPresenter.multipleChoiceInput.findViewById(R.id.optionB))
                .setText(Html.fromHtml(multipleChoiceQuestions.get(1)));
        ((Button) stormPresenter.multipleChoiceInput.findViewById(R.id.optionC))
                .setText(Html.fromHtml(multipleChoiceQuestions.get(2)));
        ((Button) stormPresenter.multipleChoiceInput.findViewById(R.id.optionD))
                .setText(Html.fromHtml(multipleChoiceQuestions.get(3)));
        ((TextView) stormPresenter.questionFrame.findViewById(R.id.currentProblem)).setText(question);
        return question;
    }
}
