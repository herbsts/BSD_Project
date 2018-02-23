/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsd.school2017.boost_it.pkgData;


public class WordBelongs {
    private Word word;
    private Unit unit;
    
    public WordBelongs() {
        this(new Word(), new Unit());
    }

    public WordBelongs(Word word, Unit unit) {
        this.word = word;
        this.unit = unit;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
    
}
