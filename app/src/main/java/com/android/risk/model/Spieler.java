package com.android.risk.model;

import java.util.ArrayList;

/**
 * @author Jürgen
 * @author Thomas
 */
public class Spieler {
    private final Farbe farbe;
    private final String name;
    private Spiel spiel;
    private int truppenzahl;
    private int ungesetzteTruppen;
    private ArrayList<Region> besetzteRegionen = new ArrayList<>();
    private boolean amZug = false;

    private Spieler(Farbe farbe, String name, Spiel spiel) {
        this.farbe = farbe;
        this.name = name;
        this.spiel = spiel;
    }

    public static Spieler getNewSpieler(Farbe farbe, String name, Spiel spiel) {
        Spieler spieler = new Spieler(farbe,name,spiel);
        spiel.spielerRegistrieren(spieler);
        return spieler;
    }

    /**
     * Vor der 1.Phase: Der Spieler bekommt je nach besetzten Gebieten eine Anzahl von Truppen
     *
     * @param anzahl : Anzahl der Truppen
     */
    public void ungesetzteTruppenHinzufuegen(int anzahl) {
        ungesetzteTruppen = anzahl;
    }

    /**
     * Rückgabe der Spielerfarbe
     *
     * @return Farbe
     */
    public Farbe getFarbe() {
        return farbe;
    }

    /**
     * 1.Phase: ungesetzte Truppen werden auf die eigenen Gebiete verteilt
     *
     * @param region: Regionen auf denen die Truppen hinzugefügt werden sollen
     * @param anzahl: Anzahl der Truppen, die gesetzt werden sollen
     */
    public void truppenSetzen(int region, int anzahl) {
        if(ungesetzteTruppen==0 || ungesetzteTruppen<anzahl){
            return;
        }
        spiel.truppenSetzen(region, anzahl);
        ungesetzteTruppen -=anzahl;
    }

    /**
     * Beendet die erste Phase
     */
    public void setzenBeenden() {
        if (ungesetzteTruppen == 0) {
            spiel.naechstePhase();
        }
    }


    /**
     * 2.Phase: Angriff und eventuelle Übernahme einer Region
     *
     * @param von:    Ausgangsgebiet
     * @param nach:   angegriffenes Gebiet
     * @param anzahl: Anzahl der angreifenden Truppen
     */
    public void angreifen(int von, int nach, int anzahl) {
        spiel.angreifen(von, nach, anzahl);
    }

    /**
     * Beendet die zweite Phase
     */
    public void angriffBeenden() {
        spiel.naechstePhase();
    }

    /**
     * 3.Phase: eigene Truppen können von einem eigenen Gebiet auf ein anderes eigenes Gebiet verschoben
     * werden,welches mit dem Ausgangsgebiet verbunden ist.
     *
     * @param von:    Ausgangsgebiet
     * @param nach:   Zielgebiet
     * @param anzahl: Anzahl der Truppen
     */
    public void truppenBewegen(int von, int nach, int anzahl) {
        spiel.truppenBewegen(von, nach, anzahl);
    }

    /**
     * Beendet die dritte Phase
     */
    public void zugBeenden() {
        spiel.naechstePhase();
    }

    /**
     * Setzt das Attribut amZug
     * @param amZug
     */
    public void setAmZug(boolean amZug) {
        this.amZug = amZug;
    }

    /**
     * Gibt eine Liste der besetzten Regionen eines Spielers zurück
     * @return
     */
    public ArrayList<Region> gibBesetzteRegionen() {
        return besetzteRegionen;
    }

    /**
     * Gibt die Anzahl der besetzten Regionen zurück
     * @return
     */
    public int gibAnzahlBesetzteRegionen() {
        return besetzteRegionen.size();
    }

}
