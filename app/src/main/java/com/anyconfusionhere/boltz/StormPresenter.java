package com.anyconfusionhere.boltz;


import android.app.Fragment;
import android.content.Intent;
import android.media.MediaPlayer;
import android.text.SpannableStringBuilder;
import android.widget.Chronometer;
import android.widget.TextView;

import com.anyconfusionhere.boltz.fragments.AlgebraInputFragment;
import com.anyconfusionhere.boltz.fragments.CalculatorInputFragment;
import com.anyconfusionhere.boltz.fragments.ComputationFragment;
import com.anyconfusionhere.boltz.fragments.FactorizationFragment;
import com.anyconfusionhere.boltz.fragments.UIFragment;
import com.anyconfusionhere.boltz.math.Bolt;

import java.util.Observable;
import java.util.Observer;

public class StormPresenter implements Observer {
    public SpannableStringBuilder question;
    public TextView questionsLeft;

    private String answer;
    private Bolt bolt;
    public Storm storm;
    public UIFragment problemFragment, factorFragment;
    public Fragment inputFragment, algebraInputFragment;
    MediaPlayer correctMP, inCorrectMP;
    int questions, currentQuestionsAttempts = 0, currentQuestionTimeTaken = 0;
    Chronometer timer;
    Intent startIntent, endScreenIntent;






    public StormPresenter(Storm stormActivity) {

        questions = 8;
        storm = stormActivity;
        startIntent = new Intent(storm, Start.class);
        endScreenIntent = new Intent(storm, EndScreen.class);
        timer = (Chronometer) storm.findViewById(R.id.timeTaken);
        questionsLeft = (TextView) storm.findViewById(R.id.questionsLeft);



        timer.start();
        timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {

            public void onChronometerTick(Chronometer chronometer) {
                chronometer.refreshDrawableState();
                currentQuestionTimeTaken++;
            }
        });
        correctMP = MediaPlayer.create(storm, R.raw.correct);
        inCorrectMP = MediaPlayer.create(storm, R.raw.incorrect);
        problemFragment = new ComputationFragment();
        inputFragment = new CalculatorInputFragment();
        factorFragment = new FactorizationFragment();
        algebraInputFragment = new AlgebraInputFragment();

        storm.getFragmentManager().beginTransaction()
                .add(R.id.problemContainer, problemFragment)
                .commit();
        storm.getFragmentManager().beginTransaction()
                .add(R.id.input_container, inputFragment)
                .commit();
        storm.getFragmentManager().beginTransaction()
                .add(R.id.problemContainer, factorFragment)
                .commit();
        storm.getFragmentManager().beginTransaction()
                .add(R.id.input_container, algebraInputFragment)
                .commit();


    }

    public Boolean check() {
        currentQuestionsAttempts++;
        Boolean correctCheck = bolt.check();
        if (correctCheck) {
            playCorrect();
            questions--;
            ReportData.getReportData().inputReportData(
                    String.valueOf(String.valueOf(question)).substring(0, question.length() - 1),
                    String.valueOf(answer),
                    String.valueOf(currentQuestionTimeTaken) + "s",
                    String.valueOf(currentQuestionsAttempts));
            currentQuestionsAttempts = 0;
            currentQuestionTimeTaken = 0;
        } else {
            playIncorrect();
        }

        if (questions == 0) {
            endScreenIntent.putExtra(Intent.EXTRA_TEXT, timer.getContentDescription());
            storm.startActivity(endScreenIntent);
        }
        bolt.erase();
        questionsLeft.setText(Integer.toString(questions));
        return false;
    }

    public void presentQuestion() {
        question = bolt.presentQuestion(this);
        answer = bolt.getAnswer();

    }

    public boolean checkAnswer(String currentAnswer) {
        return answer.equals(currentAnswer);
    }

    @Override
    public void update(Observable o, Object arg) {
        StormHandler stormHandler = (StormHandler) o;
        bolt = stormHandler.getBolt();
        presentQuestion();
    }


    public void pull() {
        bolt.pull();
    }

    public void push(String toPush) {
        bolt.push(toPush);
    }


    public void playCorrect() {
        correctMP.start();
    }

    public void playIncorrect() {
        inCorrectMP.start();
    }

    public void onBack() {
        timer.stop();
        storm.startActivity(startIntent);
    }
}
