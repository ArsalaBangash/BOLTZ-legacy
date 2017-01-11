package com.anyconfusionhere.boltz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Chronometer;
import android.widget.TextView;

public class Storm extends AppCompatActivity {
    TextView currentProblem, currentAnswer, questionsLeft;
    int questions, currentQuestionsAttempts = 0, currentQuestionTimeTaken = 0;
    MediaPlayer correctMP, inCorrectMP;
    Chronometer timer;
    StormPresenter stormPresenter;
    StormHandler stormHandler;
    Intent startIntent, endScreenIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_storm);
        questions = 8;
        stormPresenter = new StormPresenter(this);
        //Initializes TextViews, MediaPlayers, and Chronometer
        correctMP = MediaPlayer.create(this, R.raw.correct);
        inCorrectMP = MediaPlayer.create(this, R.raw.incorrect);
        currentProblem = (TextView) findViewById(R.id.currentProblem);

        questionsLeft = (TextView) findViewById(R.id.questionsLeft);
        timer = (Chronometer) findViewById(R.id.timeTaken);



        timer.start();
        timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {

            public void onChronometerTick(Chronometer chronometer) {
                chronometer.refreshDrawableState();
                currentQuestionTimeTaken++;
            }
        });

        startIntent = new Intent(Storm.this, Start.class);
        endScreenIntent = new Intent(Storm.this, EndScreen.class);

    }

    public void onStart() {
        super.onStart();
        currentAnswer = stormPresenter.problemFragment.getAnswerView();
        try {
            stormHandler = new StormHandler(this);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        stormHandler.addObserver(stormPresenter);
        stormHandler.handleBolt();

    }

    public String slice_end(String s, int endIndex) {
        if (endIndex < 0) endIndex = s.length() + endIndex;
        return s.substring(0, endIndex);
    }

    public void pull(View view) {
        if (currentAnswer.length() >0) {
            String newCurrentAnswer = slice_end(currentAnswer.getText().toString(), currentAnswer.getText().toString().length() - 1);
            currentAnswer.setText(newCurrentAnswer);
        }
    }


    public void check(View view) {
        currentQuestionsAttempts++;
        if (stormPresenter.checkAnswer(String.valueOf(currentAnswer.getText()))) {
            correctMP.start();
            questions--;
            ReportData.getReportData().inputReportData(
                    String.valueOf(String.valueOf(stormPresenter.question)).substring(0, stormPresenter.question.length() - 1),
                    String.valueOf(currentAnswer.getText()),
                    String.valueOf(currentQuestionTimeTaken) + "s",
                    String.valueOf(currentQuestionsAttempts));
            currentQuestionsAttempts = 0;
            currentQuestionTimeTaken = 0;
            stormHandler.handleBolt();

        } else {
            inCorrectMP.start();
        }

        if (questions == 0) {
                endScreenIntent.putExtra(Intent.EXTRA_TEXT, timer.getContentDescription());
                startActivity(endScreenIntent);
            }
        currentAnswer.setText("");
        questionsLeft.setText(Integer.toString(questions));
        }


    public void push(View view) {

        if (currentAnswer.getText().toString().length() < 8) {
            currentAnswer.setText(currentAnswer.getText() + view.getTag().toString());
        }
    }

    @Override
    public void onBackPressed() {
        timer.stop();
        startActivity(startIntent);
    }
}
