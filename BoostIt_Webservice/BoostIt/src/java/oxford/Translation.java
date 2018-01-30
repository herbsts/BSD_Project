/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oxford;

import data.Word;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author schueler
 */
public class Translation {

    private String configurationString = null;

    public Translation(String configString) {
        this.configurationString = configString;
    }

    public Word translate() throws Exception {
        JsonObject result = getTranslationResult(configurationString);
        return parsingTranslation(result);
    }

    private JsonObject getTranslationResult(String configString) {
        final String app_id = "10c5badd";
        final String app_key = "393252e0588c03ebd523905ecfa50d57";
        JsonObject result = null;
        try {
            URL url = new URL(configString);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("app_id", app_id);
            urlConnection.setRequestProperty("app_key", app_key);

            // read the output from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            JsonReader jr = Json.createReader(reader);

            result = jr.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(">>>>>>>>>>>JsonObject: " + result.toString());

        return result;
    }

    private Word parsingTranslation(JsonObject result) {
        Word word = new Word();
        String tGerman = "no German translation";
        String tEnglish = "no English translation";
        String varietyOfEnglish = "no variety";
        String partOfSpeech = "no part of speech";

        try {
            JsonArray resultsArr = result.getJsonArray("results");
            result = resultsArr.getJsonObject(0);

            String language = result.getString("language");
            if (language.equalsIgnoreCase("en")) {
                JsonArray lexicalEntries = result.getJsonArray("lexicalEntries");
                result = lexicalEntries.getJsonObject(0);

                partOfSpeech = result.getString("lexicalCategory");
                tEnglish = result.getString("text");

                JsonArray entries = result.getJsonArray("entries");
                result = entries.getJsonObject(0);

                JsonArray senses = result.getJsonArray("senses");
                result = senses.getJsonObject(0);

                JsonArray regions = result.getJsonArray("regions");
                if (regions != null) {
                    varietyOfEnglish = regions.toString();
                }

                JsonArray translations = result.getJsonArray("translations");
                if (translations != null) {
                    result = translations.getJsonObject(0);

                    tGerman = result.getString("text");
                } else {
                    JsonArray crossReferences = result.getJsonArray("crossReferences");
                    result = crossReferences.getJsonObject(0);

                    String id = result.getString("id");

                    String tempConfigString = "https://od-api.oxforddictionaries.com:443/api/v1/entries/en/"
                            + id + "/translations=de";

                    result = getTranslationResult(tempConfigString);

                    resultsArr = result.getJsonArray("results");
                    result = resultsArr.getJsonObject(0);

                    lexicalEntries = result.getJsonArray("lexicalEntries");
                    result = lexicalEntries.getJsonObject(0);

                    partOfSpeech = result.getString("lexicalCategory");

                    entries = result.getJsonArray("entries");
                    result = entries.getJsonObject(0);

                    senses = result.getJsonArray("senses");
                    result = senses.getJsonObject(0);

                    translations = result.getJsonArray("translations");
                    result = translations.getJsonObject(0);

                    tGerman = result.getString("text");
                }

                word.settGerman(tGerman);
                word.settEnglish(tEnglish);
                word.setVarietyOfEnglish(varietyOfEnglish);
                word.setPartOfSpeech(partOfSpeech);
            } else {
                JsonArray lexicalEntries = result.getJsonArray("lexicalEntries");
                result = lexicalEntries.getJsonObject(0);

                partOfSpeech = result.getString("lexicalCategory");
                tGerman = result.getString("text");

                JsonArray entries = result.getJsonArray("entries");
                result = entries.getJsonObject(0);

                JsonArray senses = result.getJsonArray("senses");
                result = senses.getJsonObject(0);

                JsonArray translations = result.getJsonArray("translations");
                if (translations != null) {
                    result = translations.getJsonObject(0);

                    tEnglish = result.getString("text");
                } else {
                    result = senses.getJsonObject(1);
                    
                    translations = result.getJsonArray("translations");
                    
                    result = translations.getJsonObject(0);

                    tEnglish = result.getString("text");
                }

                word.settGerman(tGerman);
                word.settEnglish(tEnglish);
                word.setPartOfSpeech(partOfSpeech);
            }

            System.out.println(">>>>>>>>>>>Translation: " + word.toString());

        } catch (Exception e) {
            word.settGerman("Error: " + e.getMessage());
        }

        return word;
    }

    public String getConfigurationString() {
        return configurationString;
    }

    public void setConfigurationString(String configurationString) {
        this.configurationString = configurationString;
    }
}
