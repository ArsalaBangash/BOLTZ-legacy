package com.anyconfusionhere.boltz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.PreferenceManager;
import android.view.View;
import android.view.Window;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_start);

    }

    /**
     * Starts the Math Practice storm
     * @param view The Start Game button
     */
    public void startGame(View view) {
        Intent speedPracticeIntent = new Intent(Start.this, Storm.class);
        startActivity(speedPracticeIntent);
    }

    /**
     * Starts the Settings activity
     * @param view The settings button
     */
    public void startSettings(View view) {
        Intent settingsIntent = new Intent(Start.this, Settings.class);
        startActivity(settingsIntent);
    }

}
