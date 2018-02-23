/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsd.school2017.boost_it.pkgData;


public class Word {

    private int word_id;                //"einfach eine nummer geben"
    private String tGerman;
    private String tEnglish;
    private String varietyOfEnglish;    //american oder british english
    private String partOfSpeech;        //lexicalCategory
    private String usage;               //soll spaeter haendisch nachgetragen werden

    public Word() {
        this(-99, "no German translation", "no English translation", "no variety", "no part of speech", "no specified usage");
    }
    
    public Word(int word_id, String tGerman, String tEnglish, String varietyOfEnglish, String partOfSpeech, String usage) {
        this.word_id = word_id;
        this.tGerman = tGerman;
        this.tEnglish = tEnglish;
        this.varietyOfEnglish = varietyOfEnglish;
        this.partOfSpeech = partOfSpeech;
        this.usage = usage;
    }

    public int getWord_id() {
        return word_id;
    }

    public void setWord_id(int word_id) {
        this.word_id = word_id;
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

    public String getVarietyOfEnglish() {
        return varietyOfEnglish;
    }

    public void setVarietyOfEnglish(String varietyOfEnglish) {
        this.varietyOfEnglish = varietyOfEnglish;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    @Override
    public String toString() {
        return "Word{" + "word_id=" + word_id + ", tGerman=" + tGerman + ", tEnglish=" + tEnglish + ", varietyOfEnglish=" + varietyOfEnglish + ", partOfSpeech=" + partOfSpeech + ", usage=" + usage + '}';
    }
}
