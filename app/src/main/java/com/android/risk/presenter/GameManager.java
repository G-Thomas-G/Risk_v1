package com.android.risk.presenter;

import android.annotation.SuppressLint;
import com.android.risk.model.*;
import java.util.HashMap;

public class GameManager {
    private Spiel spiel;
    @SuppressLint("UseSparseArrays")
    private HashMap<Integer,Spieler> spielers = new HashMap<>();
    private int missingPlayers;

    private static GameManager singleton;
    private GameManager(int anzahl) {
        spiel = new Spiel(anzahl);
        missingPlayers = anzahl;
    }
    public static GameManager getSingleton(int anzahl) {
        if (singleton==null) {
            singleton = new GameManager(anzahl);
        }
        return singleton;
    }


    public int enterSpielerName(int farbe, String name) {
        spielers.put(farbe,Spieler.getNewSpieler(farbe, name, spiel));
        return --missingPlayers;
    }

    public void setzen(int farbe, int pos, int anzahl) {
        spielers.get(farbe).truppenSetzen(pos,anzahl);
    }

    public void angreifen(int farbe, int von, int nach, int anzahl) {
        spielers.get(farbe).angreifen(von,nach,anzahl);
    }

    public void ziehen(int farbe, int von, int nach, int anzahl) {
        spielers.get(farbe).truppenBewegen(von, nach, anzahl);
    }



}
