package com.anyconfusionhere.boltz;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import com.anyconfusionhere.boltz.math.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

public class StormHandler extends Observable{
    private SpannableStringBuilder question;
    private String answer;
    private Bolt bolt;
    List boltsList = new ArrayList();

    public StormHandler(AppCompatActivity stormActivity) throws NoSuchFieldException, IllegalAccessException {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(stormActivity);
        Resources res = stormActivity.getResources();
        for (String boltString: res.getStringArray(R.array.BoltsArray)) {
            if (prefs.getBoolean(boltString, false)) {
                for (int i = 0; i <= Integer.valueOf(stormActivity.getString(R.string.class.getField(boltString).getInt(null))); i++) {
                    boltsList.add(boltString);
                }
            }
        }

    }


    public SpannableStringBuilder getQuestion() {
        return question;
    }

    public  String getAnswer() {
        return answer;
    }

    public void handleBolt() {
        Collections.shuffle(boltsList);
        bolt = BoltFactory.createBolt((String) boltsList.get(0));
        question = bolt.produceQuestion();
        answer = bolt.getAnswer();
        this.setChanged();
        this.notifyObservers(this);
    }
}