/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsd.school2017.boost_it.pkgData;



public class PhraseBelongs {
    private Unit unit;
    private Phrase phrase;

    public PhraseBelongs() {
        this(new Unit(), new Phrase());
    }
    
    public PhraseBelongs(Unit unit, Phrase phrase) {
        this.unit = unit;
        this.phrase = phrase;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Phrase getPhrase() {
        return phrase;
    }

    public void setPhrase(Phrase phrase) {
        this.phrase = phrase;
    }
    
}
