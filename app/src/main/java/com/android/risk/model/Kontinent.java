package com.android.risk.model;

/**
 * @author Thomas
 */
class Kontinent {
    private final Karte karte;
    private final Region[] regionen;
    private final String kontinentBezeichner;
    private final int truppenwert;
    private boolean einheitlichBesetzt;
    private Spieler einheitlicherBesetzer;

    Kontinent(Karte karte, String bezeichner) {
        this.karte = karte;
        kontinentBezeichner = bezeichner;
        switch (bezeichner) {
            case "Nordamerika":
                truppenwert = 5;
                regionen = new Region[]{
                        new Region(this, 0),
                        new Region(this, 1),
                        new Region(this, 2),
                        new Region(this, 3),
                        new Region(this, 4),
                        new Region(this, 5),
                        new Region(this, 6),
                        new Region(this, 7),
                        new Region(this, 8)
                };
                break;
            case "Südamerika":
                truppenwert = 2;
                regionen = new Region[]{
                        new Region(this, 9),
                        new Region(this, 10),
                        new Region(this, 11),
                        new Region(this, 12)
                };
                break;
            case "Europa":
                truppenwert = 5;
                regionen = new Region[]{
                        new Region(this, 13),
                        new Region(this, 14),
                        new Region(this, 15),
                        new Region(this, 16),
                        new Region(this, 17),
                        new Region(this, 18),
                        new Region(this, 19)
                };
                break;
            case "Asien":
                truppenwert = 7;
                regionen = new Region[]{
                        new Region(this, 20),
                        new Region(this, 21),
                        new Region(this, 22),
                        new Region(this, 23),
                        new Region(this, 24),
                        new Region(this, 25),
                        new Region(this, 26),
                        new Region(this, 27),
                        new Region(this, 28),
                        new Region(this, 29),
                        new Region(this, 30),
                        new Region(this, 31)
                };
                break;
            case "Afrika":
                truppenwert = 3;
                regionen = new Region[]{
                        new Region(this, 32),
                        new Region(this, 33),
                        new Region(this, 34),
                        new Region(this, 35),
                        new Region(this, 36),
                        new Region(this, 37)
                };
                break;
            default: //"Australien"
                truppenwert = 2;
                regionen = new Region[]{
                        new Region(this, 38),
                        new Region(this, 39),
                        new Region(this, 40),
                        new Region(this, 41)
                };
                break;
        }
    }

    /**
     * Die Methode ruft von allen Regionen Objekten die Methode zur initialisierung
     * angrenzender Gebiete auf.
     */
    void angrenzendeGebieteInitialisieren() {
        for (Region region : regionen) {
            region.angrenzendeGebieteInitialisieren(karte);
        }
    }

    /**
     * Die Methode ermittelt ob der Kontinent einheitlich, d.h. nur von einem Spieler, besetzt ist.
     *
     * @return Der ermittelte "Wert" wird zurückgegeben.
     */
    boolean istEinheitlichBesetzt() {
        Spieler besetzer = regionen[0].getBesetzer();
        boolean einheitlich = true;
        for (int i = 1; i < regionen.length; ++i) {
            einheitlich = regionen[i].getBesetzer().equals(besetzer) && einheitlich;
        }
        einheitlichBesetzt = einheitlich;
        if (einheitlich) {
            einheitlicherBesetzer = besetzer;
        } else {
            einheitlicherBesetzer = null;
        }
        return einheitlich;
    }

    /**
     * Rückgabe des in der Methode "istEinheitlichBesetzt" ermittelten Wertes.
     * Das Attribut gibt an, ob der Kontinent einheitlich besetzt ist.
     *
     * @return Das Attribut "einheitlichBesetzt"
     */
    boolean getEinheitlichBesetzt() {
        return einheitlichBesetzt;
    }

    /**
     * Das Attribut gibt an, wer den Kontinent vollständig besetzt.
     * Falls nicht nur eine Person Regionen auf diesem Kontinent besetzt hat ist der Wert "null".
     *
     * @return Das Attribut "einheitlicherBesetzer"
     */
    Spieler getBesetzer() {
        return einheitlicherBesetzer;
    }

    /**
     * Das Attribut ist eine vom Kontinent abhängige Konstante. Sie gibt an, wie viele
     * zusätzliche Einheiten man am Anfang einer Phase bekommt, wenn man der alleinige Besetzer
     * des Kontinents ist.
     *
     * @return Das Attribut "Truppenwert".
     */
    int getTruppenwert() {
        return truppenwert;
    }

    /**
     * Die Methode reicht die Anfrage nach dem Besetzer einer Region an
     *
     * @param region Die Regionenkennziffer der zu erhaltenden Region.
     * @return Der Besetzer der fraglichen Region.
     */
    Spieler getBesetzerRegion(int region) {
        return getRegion(region).getBesetzer();
    }

    /**
     * Die Methode gibt einen Wert zurück, der verwendet wird, um von der allgemeinen
     * Regionenkennziffer auf die Stelle im Array (Das Attribut "regionen") schließen zu können.
     *
     * @return
     */
    private int regionenOffset() {
        switch (kontinentBezeichner) {
            case "Nordamerika":
                return 0;
            case "Südamerika":
                return 9;
            case "Europa":
                return 13;
            case "Asien":
                return 20;
            case "Afrika":
                return 32;
            default:
                return 38;
        }
    }

    /**
     * Gibt die gesuchte Region zurück. Die Methode "regionenOffset" wird hier verwendet,
     * um von der allgemeinen Regionenkennziffer auf die Stelle im Array zu schließen.
     *
     * @param region Die Regionenkennziffer der gesuchten Region.
     * @return Die gesuchte Region.
     */
    Region getRegion(int region) {
        return regionen[region - regionenOffset()];
    }

    /**
     * Gibt das Attribut Karte zurück.
     *
     * @return Das Attribut Karte.
     */
    Karte getKarte() {
        return karte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kontinent kontinent1 = (Kontinent) o;
        return kontinentBezeichner.equals(kontinent1.kontinentBezeichner);
    }

    @Override
    public int hashCode() {
        int ausg;
        switch (kontinentBezeichner) {
            case "Nordamerika":
                ausg = 0;
                break;
            case "Südamerika":
                ausg = 1;
                break;
            case "Europa":
                ausg = 2;
                break;
            case "Afrika":
                ausg = 3;
                break;
            case "Asien":
                ausg = 4;
                break;
            default:
                ausg = 5;
                break; //gleichwertig zu "Australien"
        }
        return ausg;
    }
}
