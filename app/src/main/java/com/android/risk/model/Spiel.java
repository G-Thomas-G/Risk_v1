package com.android.risk.model;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @author Timo, Thomas
 */
public class Spiel {
    private Karte karte;
    private Spieler spieler[];

    /**
     * -2 Registrierung der Spieler
     * -1 Setzen der verfügbaren Truppen
     * 0  Truppen setzen
     * 1  angreifen
     * 2  Truppen bewegen
     */
    private int phase = -2;
    private int amZug = 0;

    /**
     * Erzeugt ein neues Objekt der Klasse Spiel.
     *
     * @param anzahlSpieler Die Anzahl an Spielern, die sich am Spiel beteiligen.
     */
    public Spiel(int anzahlSpieler) {
      /*
        if (anzahlSpieler<2 || anzahlSpieler>6) {


        }
      */
        spieler = new Spieler[anzahlSpieler];
    }

    /**
     * Wird aufgerufen, wenn der Übergang in die nächste Phase vorgenommen wird.
     */
    void naechstePhase() {
        phase = (phase + 1) % 3; //immer ein Kreislauf: 0,1,2,0,1,2,......
        if (phase == 0) {
            spieler[amZug].setAmZug(false);
            amZug = (amZug + 1) % spieler.length; //ebenfalls ein Kreislauf: Wenn alle Spieler an der Reihe waren: wieder der erste
            spieler[amZug].setAmZug(true);
//            truppenHinzufuegen();
        }
    }

    /**
     * Berechnet die zu vergebende Anzahl an Truppen und gibt sie an den Spieler weiter.
     */
    private void truppenHinzufuegen() {
        int truppenanzahl = 3;

        //Kontinente
        ArrayList<Kontinent> besetzteKontinente = karte.getBesetzungen(spieler[amZug]);
        ListIterator<Kontinent> kontinentIterator = besetzteKontinente.listIterator(0);
        do {
            Kontinent kontinentspeicher = kontinentIterator.next();
            truppenanzahl += kontinentspeicher.getTruppenwert();
        }
        while (kontinentIterator.hasNext());

        int spielerregionen = spieler[amZug].gibAnzahlBesetzteRegionen();
        if (!(spielerregionen <= 12)) {
            spielerregionen -= 12;
            while (spielerregionen >= 3) {
                spielerregionen -= 3;
                truppenanzahl++;
            }
        }
        spieler[amZug].ungesetzteTruppenHinzufuegen(truppenanzahl);
    }

    /**
     * Setzt eine gegebene Anzahl an Truppen in eine Zielregion.
     *
     * @param region Gibt die Zielregion an
     * @param anzahl Die Anzahl der zu setzenden Truppen
     */
    void truppenSetzen(int region, int anzahl) {
        if (phase == 0 || phase == -1) {
            Region zielregion = karte.getRegion(region);
            if (spieler[amZug] == zielregion.getBesetzer()) {
                zielregion.truppenHinzufuegen(anzahl);
            }
        }

    }

    /**
     * Beendet die Phase des Truppensetzens und geht in die nächste Phase über.
     */
    void setzenBeenden() {
        phase = (phase + 1) % 3; //immer ein Kreislauf: 0,1,2,0,1,2,......
        //TODO Speichern der Truppen?
    }

    /**
     * Steuert den Angriffsvorgang von einem Gebiet zum anderen und berechnet die Verluste
     * und entscheidet so, ob das Gebiet erobert wurde.
     *
     * @param von    Eigenes Gebiet, von dem der Angriff ausgeht.
     * @param nach   Zielgebiet, das angegriffen wird.
     * @param anzahl Anzahl der angreifenden Truppen
     */
    void angreifen(int von, int nach, int anzahl) {
        if (phase == 1) {
            //TODO Angreifen Methode
        }
    }

    /**
     * Beendet die Phase des Angreifens und geht in die nächste Phase über.
     */
    void angriffBeenden() {
        if (phase == 1) {
            phase = (phase + 1) % 3; //immer ein Kreislauf: 0,1,2,0,1,2,......
        }
    }

    /**
     * Bewegt Truppen von einem vom Spieler besetzten Gebiet zu einem anderen
     * vom Spieler besetzten Gebiet.
     *
     * @param von    Das Gebiet, aus dem die Truppen abgezogen werden.
     * @param nach   Das Zielgebiet, in das die Truppen verlegt werden.
     * @param anzahl Die Anzahl der verlegten Truppen
     */
    void truppenBewegen(int von, int nach, int anzahl) {
        if (phase == 2) {
            //TODO Truppen bewegen
        }
    }

    /**
     * Beendet den laufenden Zug und der nächste Spieler ist an der Reihe.
     */
    void zugBeenden() {
        spieler[amZug].setAmZug(false);
        amZug = (amZug + 1) % spieler.length; //Kreislauf: Wenn alle Spieler an der Reihe waren: wieder der erste
        spieler[amZug].setAmZug(true);
    }

    /**
     * Speichert einen Spieler im Array ab und nimmt ihn so mit in das Spiel.
     *
     * @param spieler Ein Spieler, der regestriert werden muss.
     */
    public void spielerRegistrieren(Spieler spieler) {
        if (phase == -2) {
            this.spieler[amZug++] = spieler;
            if (amZug == this.spieler.length) {
                ++phase;
                amZug = 0;
            }
        }
    }

}
