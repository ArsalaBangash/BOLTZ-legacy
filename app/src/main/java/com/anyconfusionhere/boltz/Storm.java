package com.anyconfusionhere.boltz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Chronometer;
import android.widget.TextView;

public class Storm extends AppCompatActivity {
    public StormPresenter stormPresenter;
    StormHandler stormHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_storm);
        stormPresenter = new StormPresenter(this);
        //Initializes TextViews, MediaPlayers, and Chronometer



    }

    public void onStart() {
        super.onStart();
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

    public void pull(View view) {
        stormPresenter.pull();

    }


    public void check(View view) {
        stormHandler.handleBolt();
        if (stormPresenter.check()) {
        }



    }


    public void push(View view) {
        stormPresenter.push(view.getTag().toString());
    }

    @Override
    public void onBackPressed() {
        stormPresenter.onBack();

    }
}
