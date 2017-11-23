package bsd.school2017.boost_it.pkgThreads;

import android.os.AsyncTask;
import android.util.Log;

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
            Log.e("test", result);
            /*JSONObject js = new JSONObject(result);
            JSONArray results = js.getJSONArray("results");
            for(int i = 0;i<results.length();i++){
                JSONObject lentries = results.getJSONObject(i);
                JSONArray la = lentries.getJSONArray("lexicalEntries");
                for(int j=0;j<la.length();j++){
                    JSONObject entries = la.getJSONObject(j);
                    JSONArray e = entries.getJSONArray("entries");
                    for(int i1=0;i1<e.length();i1++){
                        JSONObject senses = la.getJSONObject(i1);
                        JSONArray s = entries.getJSONArray("senses");
                        JSONObject d = s.getJSONObject(0);
                        JSONArray de = d.getJSONArray("definitions");
                        translation = de.getString(0);
                    }
                }
            }*/
            delegate.processFinish(result);
            Log.e("def", result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}