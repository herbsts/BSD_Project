/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import data.Word;
import java.util.concurrent.TimeUnit;
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
@Path("WordDetail")
public class WordDetail {

    public WordDetail() {
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
    @Path("{word}")
    public Word getWord(@PathParam("word") String word) {
        Word retWord = null;
        String translation = null;

        String configString = configurateTranslation(word);
        
        Translation t = new Translation(configString);
        
        try {
            translation = t.translate();
        } catch(Exception ex) {
            translation = ex.getMessage();
        }

        retWord = new Word();

        System.out.println("==============webservice BoostIt GET called TRANSLATION: " + translation);

        return retWord;
    }

    private String configurateTranslation(String word) {
        return "https://od-api.oxforddictionaries.com:443/api/v1/entries/en/"
                + word.toLowerCase() + "/translations=de";
    }
}
