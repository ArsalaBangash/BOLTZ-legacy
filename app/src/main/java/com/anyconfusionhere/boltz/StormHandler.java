package com.anyconfusionhere.boltz;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import com.anyconfusionhere.boltz.math.Bolt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

class StormHandler extends Observable {
    private List boltsList = new ArrayList();
    private Storm stormActivity;
    private Bolt bolt;

    StormHandler(Storm newStormActivity) throws NoSuchFieldException, IllegalAccessException {
        stormActivity = newStormActivity;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(stormActivity);
        Resources res = stormActivity.getResources();
        for (String boltString : res.getStringArray(R.array.BoltsArray)) {
            if (prefs.getBoolean(boltString, false)) {
                for (int i = 0; i <= Integer.valueOf(stormActivity
                        .getString(R.string.class.getField(boltString).getInt(null))); i++) {
                    boltsList.add(boltString);
                }
            }
        }

    }

    public Bolt getBolt() {
        return bolt;
    }

    void handleBolt() {
        Collections.shuffle(boltsList);
        bolt = BoltFactory.createBolt((String) boltsList.get(0), stormActivity);
        this.setChanged();
        this.notifyObservers(this);
    }
}
