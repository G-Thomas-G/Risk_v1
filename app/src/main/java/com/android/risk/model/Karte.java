package com.android.risk.model;

import java.util.ArrayList;

/**
 * @author Thomas
 */
class Karte {
    private Kontinent kontinente[];
    private boolean[] besucht = new boolean[42];

    Karte() {
        kontinente = new Kontinent[6];
        kontinente[0] = new Kontinent(this, "Nordamerika");
        kontinente[1] = new Kontinent(this, "Südamerika");
        kontinente[2] = new Kontinent(this, "Europa");
        kontinente[3] = new Kontinent(this, "Asien");
        kontinente[4] = new Kontinent(this, "Afrika");
        kontinente[5] = new Kontinent(this, "Australien");

        for (Kontinent kontinent : kontinente) {
            kontinent.angrenzendeGebieteInitialisieren();
        }
    }

    /**
     * Die Methode gibt an, ob zwei Regionen des selben Besetzers verbunden sind.
     * Als Verbunden gelten zwei Regionen, wenn es einen Pfad (def. Graphen) gibt,
     * der nur über Regeionen führt, die von einem Spieler besetzt sind.
     *
     * @param von  Die Regionenkennziffer der ersten Region.
     * @param nach Die Regionenkennziffer der zweiten Region.
     * @return Gibt an, ob eine Verbindung mit den oben genannten vorraussetzungen besteht.
     */
    boolean verbunden(int von, int nach) {
        besucht = new boolean[42];
        if (von == nach) return true;
        if (!getBesetzerRegion(von).equals(getBesetzerRegion(nach))) return false;
        return getRegion(von).verbunden(nach);
    }

    /**
     * Die Methode gibt das Attribut "besucht" zurück.
     * Das Attribut wird in der Methode "verbunden" der Klasse "Region" beim Graphendurchlauf
     * verwendet.
     *
     * @return Das Attribut "besucht"
     */
    boolean[] getBesucht() {
        return besucht;
    }

    /**
     * Gibt die Region aus dem jeweiligem Kontinent zurück
     * @param region
     * @return
     */
    Region getRegion(int region) {
        if (region < 9) {
            return kontinente[0].getRegion(region);
        } else if (region < 13) {
            return kontinente[1].getRegion(region);
        } else if (region < 20) {
            return kontinente[2].getRegion(region);
        } else if (region < 32) {
            return kontinente[3].getRegion(region);
        } else if (region < 38) {
            return kontinente[4].getRegion(region);
        } else {
            return kontinente[5].getRegion(region);
        }
    }

    /**
     * Gibt den Besetzer der ausgewählten Region zurück
     * @param region
     * @return
     */
    Spieler getBesetzerRegion(int region) {
        return getRegion(region).getBesetzer();
    }

    /**
     * Gibt die Besetzungen eines Spielers zurück
     * @param spieler
     * @return
     */
    ArrayList<Kontinent> getBesetzungen(Spieler spieler) {
        ArrayList<Kontinent> ausg = new ArrayList<>(4);
        for (Kontinent kontinent : kontinente) {
            if (!kontinent.getEinheitlichBesetzt() || kontinent.getBesetzer() != spieler) continue;
            ausg.add(kontinent);
        }
        return ausg;
    }

}
