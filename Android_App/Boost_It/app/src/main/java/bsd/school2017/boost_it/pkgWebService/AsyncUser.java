package bsd.school2017.boost_it.pkgWebService;

/**
 * Created by Martin on 25.01.2018.
 */

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import bsd.school2017.boost_it.pkgDatabase.Database;

public class AsyncUser extends AsyncTask<Object, Void, String> {
    private static final String URL = Database.getURL();
    private static final String contentType = Database.getContentType();
    private Gson gson;

    @Override
    protected String doInBackground(Object... command) {    //(Method, URL, value)
        BufferedReader reader;
        URL url;
        String response = null;
        gson = new Gson();

        try{
            if (command[0].equals("GET")){
                url = new URL(URL + command[1]);
                URLConnection conn = url.openConnection();

                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = null;

                while((line = reader.readLine()) != null) {
                    sb.append(line);
                }

                response = sb.toString();
                reader.close();
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }

        return response;
    }
}