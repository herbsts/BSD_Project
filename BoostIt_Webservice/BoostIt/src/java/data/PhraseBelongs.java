/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author schueler
 */
@XmlRootElement
public class PhraseBelongs {
    private Phrase phrase;
    private Unit unit;

    public PhraseBelongs() {
        this(new Phrase(), new Unit());
    }
    
    public PhraseBelongs(Phrase phrase, Unit unit) {
        this.phrase = phrase;
        this.unit = unit;
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
