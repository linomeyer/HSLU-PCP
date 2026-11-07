package ch.hslu.pcp.week_8.e01;

public class Exercise1 implements SpecificInterface, GeneralInterface {
    void main() {
        var ex1 = new Exercise1();
        ex1.doIt(); // a) prints "Do it the SPECIFIC way."
        // b) Da SpecificInterface GeneralInterface implementiert / erweitert gibt es kein Problem
        // Regel: das spezifischere Interface gewinnt, also SpecificInterface

        // c) es gibt zwei Implementation für die gleiche Methodensignatur.
        // Keines erweitert das andere, also gibt es kein spezifischers.
        // Compiler kann nicht wissen welches es nehmen soll.
        // Lösungen:
        // Direkt in Exercise1 überschreiben
        // mit {Interface}.super.doIt() eine implementierung auswählen oder beide oder eine eigene machen.
    }

    /* c)
    @Override
    public void doIt() {
        SpecificInterface.super.doIt();
    }
     */
}
