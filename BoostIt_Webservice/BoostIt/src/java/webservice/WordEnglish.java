/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import data.Word;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import oxford.Translation;

/**
 * REST Web Service
 *
 * @author schueler
 */
@Path("WordEnglish")
public class WordEnglish {

    public WordEnglish() {
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
    @Path("{english_word}")
    public Word getGermanWord(@PathParam("english_word") String english_word) {
        Word retWord = new Word();

        String configString = configurateTranslation(english_word);
        
        Translation t = new Translation(configString);
        
        try {
            retWord = t.translate();
        } catch(Exception ex) {
            retWord.settGerman("Fehler: " + ex.getMessage());
        }

        System.out.println("==============webservice BoostIt GET called TRANSLATION: " + retWord.toString());

        return retWord;
    }

    private String configurateTranslation(String word) {
        return "https://od-api.oxforddictionaries.com:443/api/v1/entries/en/"
                + word.toLowerCase() + "/translations=de";
    }
}
