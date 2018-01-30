/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsd.school2017.boost_it.pkgData;


public class Phrase {

    private int phrase_id;
    private String tGerman;
    private String tEnglish;
    private Word word;

    public Phrase() {
        this(-99, "no German translation", "no English translation", new Word());
    }
    
    public Phrase(int phrase_id, String tGerman, String tEnglish, Word word) {
        this.phrase_id = phrase_id;
        this.tGerman = tGerman;
        this.tEnglish = tEnglish;
        this.word = word;
    }

    public int getPhrase_id() {
        return phrase_id;
    }

    public void setPhrase_id(int phrase_id) {
        this.phrase_id = phrase_id;
    }

    public String gettGerman() {
        return tGerman;
    }

    public void settGerman(String tGerman) {
        this.tGerman = tGerman;
    }

    public String gettEnglish() {
        return tEnglish;
    }

    public void settEnglish(String tEnglish) {
        this.tEnglish = tEnglish;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }
}
