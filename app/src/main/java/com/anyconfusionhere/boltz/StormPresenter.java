package com.anyconfusionhere.boltz;


import android.content.Intent;
import android.media.MediaPlayer;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.anyconfusionhere.boltz.math.Bolt;
import java.util.Observable;
import java.util.Observer;

public class StormPresenter implements Observer {
    public SpannableStringBuilder question;
    private TextView questionsLeft;
    private String answer;
    private Bolt bolt;
    public Storm storm;
    private MediaPlayer correctMP, inCorrectMP;
    private int questions, currentQuestionsAttempts = 0, currentQuestionTimeTaken = 0;
    private Chronometer timer;
    private Intent startIntent, endScreenIntent;
    public FrameLayout inputFrame, questionFrame;
    public View factorProblem, simpleProblem, calcInput, algInput;






    public StormPresenter(Storm stormActivity) {

        questions = 8;
        storm = stormActivity;
        startIntent = new Intent(storm, Start.class);
        endScreenIntent = new Intent(storm, EndScreen.class);
        timer = (Chronometer) storm.findViewById(R.id.timeTaken);
        questionsLeft = (TextView) storm.findViewById(R.id.questionsLeft);


        /*
        Creates the frames for question and input, and inflates the layouts from xml files for
        each type of input and question, adding them to the frames
         */
        questionFrame = (FrameLayout) storm.findViewById(R.id.problemContainer);
        inputFrame = (FrameLayout) storm.findViewById(R.id.input_container);
        factorProblem = storm.getLayoutInflater().inflate(R.layout.factorisation_problem, null);
        simpleProblem = storm.getLayoutInflater().inflate(R.layout.simple_problem, null);
        calcInput = storm.getLayoutInflater().inflate(R.layout.calculator_input, null);
        algInput = storm.getLayoutInflater().inflate(R.layout.algebra_input, null);
        questionFrame.addView(factorProblem);
        questionFrame.addView(simpleProblem);
        inputFrame.addView(algInput);
        inputFrame.addView(calcInput);


        //Starts timer and loads audio resources
        timer.start();
        timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {

            public void onChronometerTick(Chronometer chronometer) {
                chronometer.refreshDrawableState();
                currentQuestionTimeTaken++;
            }
        });
        correctMP = MediaPlayer.create(storm, R.raw.correct);
        inCorrectMP = MediaPlayer.create(storm, R.raw.incorrect);


    }

    /**
     * This function is called when the check operator is pressed. If the answer for a particular
     * question was correct, then the question's data is stored for the report; otherwise the player
     * receives an incorrect sound.
     * @return
     */
    Boolean check() {
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
        } else {playIncorrect();}

        handleQuestions();
        bolt.erase();
        return correctCheck;
    }

    public void presentQuestion() {
        question = bolt.presentQuestion(this);
        answer = bolt.getAnswer();
    }



    @Override
    public void update(Observable o, Object arg) {
        StormHandler stormHandler = (StormHandler) o;
        bolt = stormHandler.getBolt();
        presentQuestion();
    }


    void pull() {
        bolt.pull();
    }

    void push(String toPush) {
        bolt.push(toPush);
    }

    /**
     * Plays the correct sound when the user correctly answers a question.
     */
    private void playCorrect() {
        correctMP.start();
    }

    /**
     * Plays the incorrect sound when the user incorrectly answers a question.
     */
    private void playIncorrect() {
        inCorrectMP.start();
    }

    /**
     * Called when the Android back button is pressed. Stops the timer and sends the user back to the
     * main menu
     */
    void onBack() {
        timer.stop();
        storm.startActivity(startIntent);
    }

    /**
     * Called every time the check function is executed. The function displays the number of questions
     * left and starts the end screen if there are no questions remaining.
     */
    private void handleQuestions(){
        questionsLeft.setText(Integer.toString(questions));
        if (questions == 0) {
            endScreenIntent.putExtra(Intent.EXTRA_TEXT, timer.getContentDescription());
            storm.startActivity(endScreenIntent);
        }
    }
}
