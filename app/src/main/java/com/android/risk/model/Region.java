package com.android.risk.model;

import java.util.Objects;

/**
 * Die Klasse "Region" ist der kleinste Bestandteil der "Welt" des Spiels.
 * Sie enthält ihren Kontinent, die auf ihr stationierten Truppen, der Besetzer der Region,
 * eine Regionen kennziffer und die Angrenzenden Gebiete.
 *
 * @author Thomas
 */
class Region {
    private final Kontinent accordingKontinent;
    /**
     * Regionenbezeichner
     */
    private final int regionenname;
    /**
     * 0  Alaska
     * 1  Nordwest-Territorium
     * 2  Grönland
     * 3  Alberta
     * 4  Ontario
     * 5  Quebec/Ost-Kanada
     * 6  Western United States
     * 7  Eastern United States
     * 8  Zentralamerika
     * --
     * 9  Venezuela
     * 10 Brazilien
     * 11 Peru
     * 12 Argentinien
     * --
     * 13 Island
     * 14 Großbritannien
     * 15 Skandinavien
     * 16 Russland
     * 17 Nordeuropa
     * 18 Südeuropa
     * 19 Westeuropa
     * --
     * 20 Ural
     * 21 Sibirien
     * 22 "Yakursk"
     * 23 Kamtschatka
     * 24 Irkutsk
     * 25 Mongolei
     * 26 Japan
     * 27 China
     * 28 Afgahnistan
     * 29 "Middle East"
     * 30 Indien
     * 31 Siam
     * --
     * 32 Nordafrika
     * 33 Ägypten
     * 34 Ostafrika
     * 35 Kongo
     * 36 Südafrika
     * 37 Madagaskar
     * --
     * 38 Indonesien
     * 39 Neuginea
     * 40 Westaustralien
     * 41 Ostaustralien
     */
    private Region[] angrenzendeGebiete;
    private int truppen = 0;
    private Spieler besetzer;

    Region(Kontinent kontinent, int regionenname) {
        this.accordingKontinent = kontinent;
        this.regionenname = regionenname;

    }

    /**
     * Initialisierung der angrenzenden Gebiete.
     * Die Methode wird nach der Erzeugung der Kontinente und damit aller Regionen
     * im Konstruktor der "Karte" aufgerufen.
     *
     * @param karte Das Kartenobjekt in welchem diese Region enthalten ist.
     */
    void angrenzendeGebieteInitialisieren(Karte karte) {
        switch (regionenname) {
            case 0:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(1),
                        karte.getRegion(3),
                        karte.getRegion(23)
                };
                break;
            case 1:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(0),
                        karte.getRegion(2),
                        karte.getRegion(3),
                        karte.getRegion(4)
                };
                break;
            case 2:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(1),
                        karte.getRegion(4),
                        karte.getRegion(5),
                        karte.getRegion(13)
                };
                break;
            case 3:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(0),
                        karte.getRegion(1),
                        karte.getRegion(4),
                        karte.getRegion(6)
                };
                break;
            case 4:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(1),
                        karte.getRegion(2),
                        karte.getRegion(3),
                        karte.getRegion(5),
                        karte.getRegion(6),
                        karte.getRegion(7)
                };
                break;
            case 5:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(2),
                        karte.getRegion(4),
                        karte.getRegion(7)
                };
                break;
            case 6:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(3),
                        karte.getRegion(4),
                        karte.getRegion(7),
                        karte.getRegion(8)
                };
                break;
            case 7:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(4),
                        karte.getRegion(5),
                        karte.getRegion(6),
                        karte.getRegion(8)
                };
                break;
            case 8:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(6),
                        karte.getRegion(7),
                        karte.getRegion(9)
                };
                break;
            case 9:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(8),
                        karte.getRegion(10),
                        karte.getRegion(11)
                };
                break;
            case 10:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(9),
                        karte.getRegion(11),
                        karte.getRegion(12),
                        karte.getRegion(32)
                };
                break;
            case 11:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(9),
                        karte.getRegion(10),
                        karte.getRegion(12)
                };
                break;
            case 12:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(10),
                        karte.getRegion(11)
                };
                break;
            case 13:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(2),
                        karte.getRegion(14),
                        karte.getRegion(15)
                };
                break;
            case 14:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(13),
                        karte.getRegion(15),
                        karte.getRegion(17),
                        karte.getRegion(19)
                };
                break;
            case 15:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(13),
                        karte.getRegion(14),
                        karte.getRegion(16),
                        karte.getRegion(17)
                };
                break;
            case 16:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(15),
                        karte.getRegion(17),
                        karte.getRegion(18),
                        karte.getRegion(20),
                        karte.getRegion(28),
                        karte.getRegion(29)
                };
                break;
            case 17:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(14),
                        karte.getRegion(15),
                        karte.getRegion(16),
                        karte.getRegion(18),
                        karte.getRegion(19)
                };
                break;
            case 18:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(16),
                        karte.getRegion(17),
                        karte.getRegion(19),
                        karte.getRegion(29),
                        karte.getRegion(32),
                        karte.getRegion(33)
                };
                break;
            case 19:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(14),
                        karte.getRegion(17),
                        karte.getRegion(18),
                        karte.getRegion(32)
                };
                break;
            case 20:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(16),
                        karte.getRegion(21),
                        karte.getRegion(27),
                        karte.getRegion(28)
                };
                break;
            case 21:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(20),
                        karte.getRegion(22),
                        karte.getRegion(24),
                        karte.getRegion(25),
                        karte.getRegion(27)
                };
                break;
            case 22:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(21),
                        karte.getRegion(23),
                        karte.getRegion(24)
                };
                break;
            case 23:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(0),
                        karte.getRegion(22),
                        karte.getRegion(24),
                        karte.getRegion(25),
                        karte.getRegion(26)
                };
                break;
            case 24:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(21),
                        karte.getRegion(22),
                        karte.getRegion(23),
                        karte.getRegion(25)
                };
                break;
            case 25:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(21),
                        karte.getRegion(23),
                        karte.getRegion(24),
                        karte.getRegion(26),
                        karte.getRegion(27)
                };
                break;
            case 26:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(23),
                        karte.getRegion(25)
                };
                break;
            case 27:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(20),
                        karte.getRegion(21),
                        karte.getRegion(25),
                        karte.getRegion(28),
                        karte.getRegion(30),
                        karte.getRegion(31)
                };
                break;
            case 28:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(16),
                        karte.getRegion(20),
                        karte.getRegion(27),
                        karte.getRegion(29),
                        karte.getRegion(30)
                };
                break;
            case 29:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(16),
                        karte.getRegion(18),
                        karte.getRegion(28),
                        karte.getRegion(30),
                        karte.getRegion(33),
                        karte.getRegion(34)
                };
                break;
            case 30:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(27),
                        karte.getRegion(28),
                        karte.getRegion(29),
                        karte.getRegion(31)
                };
                break;
            case 31:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(27),
                        karte.getRegion(30),
                        karte.getRegion(38)
                };
                break;
            case 32:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(10),
                        karte.getRegion(18),
                        karte.getRegion(19),
                        karte.getRegion(33),
                        karte.getRegion(34),
                        karte.getRegion(35)
                };
                break;
            case 33:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(18),
                        karte.getRegion(29),
                        karte.getRegion(32),
                        karte.getRegion(34)
                };
                break;
            case 34:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(29),
                        karte.getRegion(32),
                        karte.getRegion(33),
                        karte.getRegion(35),
                        karte.getRegion(36),
                        karte.getRegion(37)
                };
                break;
            case 35:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(32),
                        karte.getRegion(34),
                        karte.getRegion(36)
                };
                break;
            case 36:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(34),
                        karte.getRegion(35),
                        karte.getRegion(37)
                };
                break;
            case 37:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(34),
                        karte.getRegion(36)
                };
                break;
            case 38:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(31),
                        karte.getRegion(39),
                        karte.getRegion(40)
                };
                break;
            case 39:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(38),
                        karte.getRegion(40),
                        karte.getRegion(41)
                };
                break;
            case 40:
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(38),
                        karte.getRegion(39),
                        karte.getRegion(41)
                };
                break;
            default: //41
                angrenzendeGebiete = new Region[]{
                        karte.getRegion(39),
                        karte.getRegion(40)
                };
        }
    }

    /**
     * Überprüft ob zwischen dieser Region und der Region als Parameter eine Verbindung besteht.
     * Verbunden gelten zwei Regionen, wenn es einen Pfad, nur über Regionen des selben Besatzers,
     * existiert.
     *
     * @param ziel Die Regionenkennziffer der Region von der es zu überprüfen gilt, ob eine
     *             Verbindung besteht.
     * @return Existens eines Pfades.
     */
    boolean verbunden(int ziel) {
        if (regionenname == ziel) return true;
        boolean[] besucht = accordingKontinent.getKarte().getBesucht();
        besucht[regionenname] = true;

        for (Region akktuell : angrenzendeGebiete) {
            if (akktuell.getBesetzer().equals(besetzer) && !besucht[akktuell.regionenname]) {
                if (akktuell.verbunden(ziel)) return true;
            }
        }
        return false;
    }

    /**
     * Die Methode ist für alle Phasen von Bedeutung.
     * Die Menge der Truppen wird der aktuellen Truppenzahl hinzugefügt.
     *
     * @param anzahl Die Anzahl der hinzuzufügenden Truppen.
     */
    void truppenHinzufuegen(int anzahl) {
        truppen += anzahl;
    }

    /**
     * Die Methode ist sowohl für die 2. Phase , als auch für die 3. Phase von Bedeutung.
     *
     * @param anzahl Die Anzahl der zu entfernenden Truppen.
     */
    void truppenEntfernen(int anzahl) {
        truppen -= anzahl;
    }

    /**
     * Eine simple Methode um den "Besetzer" der Region zu erhalten.
     *
     * @return Der Besetzer der Region.
     */
    Spieler getBesetzer() {
        return besetzer;
    }

    /**
     * Die Methode ist am Anfang des Spiels und auch danach bei Eroberungen wichtig.
     *
     * @param nBesetzer Der neue Besetzer der Region
     */
    void setBesetzer(Spieler nBesetzer) {
        besetzer = nBesetzer;
        accordingKontinent.istEinheitlichBesetzt();
    }

    int gibTruppenanzahl(){
        return truppen;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return regionenname == region.regionenname;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accordingKontinent, regionenname);
    }


}
