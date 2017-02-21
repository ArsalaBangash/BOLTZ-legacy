package com.anyconfusionhere.boltz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

public class Storm extends AppCompatActivity {
    public StormPresenter stormPresenter;
    StormHandler stormHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_storm);
        stormPresenter = new StormPresenter(this);
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
        if (stormPresenter.check(view.getTag().toString())) {
            stormHandler.handleBolt();
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
