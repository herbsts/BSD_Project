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
@Path("WordGerman")
public class WordGerman {

    public WordGerman() {
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
    @Path("{german_word}")
    public Word getEnglishWord(@PathParam("german_word") String german_word) {
        Word retWord = new Word();

        String configString = configurateTranslation(german_word);
        
        Translation t = new Translation(configString);
        
        try {
            retWord = t.translate();
        } catch(Exception ex) {
            retWord.settEnglish("Error: " + ex.getMessage());
        }

        System.out.println("==============webservice BoostIt GET called TRANSLATION: " + retWord.toString());

        return retWord;
    }

    private String configurateTranslation(String word) {
        return "https://od-api.oxforddictionaries.com:443/api/v1/entries/de/"
                + word.toLowerCase() + "/translations=en";
    }
}
