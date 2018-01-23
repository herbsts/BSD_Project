package bsd.school2017.boost_it.pkgThreads;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Martin on 20.10.2017.
 */
public class AsyncTranslation extends AsyncTask<String, Integer, String> {
    public IAsyncTaskResponse delegate = null;

    @Override
    protected String doInBackground(String... params) {
        final String app_id = "10c5badd";
        final String app_key = "393252e0588c03ebd523905ecfa50d57";
        try {
            URL url = new URL(params[0]);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("app_id", app_id);
            urlConnection.setRequestProperty("app_key", app_key);

            // read the output from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            return stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        String translation = null;
        try {
            JSONObject obj = new JSONObject(result);
            JSONArray resultsArr = obj.getJSONArray("results");
            obj = resultsArr.getJSONObject(0);
            JSONArray lexicalEntries = obj.getJSONArray("lexicalEntries");
            obj = lexicalEntries.getJSONObject(0);
            JSONArray entries = obj.getJSONArray("entries");
            obj = entries.getJSONObject(0);
            JSONArray senses = obj.getJSONArray("senses");
            obj = senses.getJSONObject(0);
            JSONArray translations = obj.getJSONArray("translations");
            obj = translations.getJSONObject(0);
            String finalTranslation = obj.get("text").toString();

            delegate.processFinish(finalTranslation);
            Log.e("def", finalTranslation);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}