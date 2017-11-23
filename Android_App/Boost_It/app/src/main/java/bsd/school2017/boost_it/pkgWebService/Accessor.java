package bsd.school2017.boost_it.pkgWebService;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Martin on 23.11.2017.
 */

public final class Accessor {
    private static String serverUrl = "http://{ip}:{port}/BoostIt/services/";
    private static Context ctx = null;
    private static boolean initialized = false;

    public static void init(Context context) {
        ctx = context;
        initialized = true;
    }

    private static String generateUrl() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(ctx);
        //TODO: insert right IP and PORT
        return serverUrl.replace("{ip}", sp.getString("preference_webservice_ip", "192.12.12.12.12")).replace("{port}", sp.getString("preference_webservice_port", "insert port"));
    }

    public static void runRequestAsync(HttpMethod httpMethod, String uriPath, String uriQuery, String requetsBody, WebRequestTaskListener listener) throws Exception {
        runRequestAsync(httpMethod, uriPath, uriQuery, requetsBody, listener, 5000);
    }

    public static void runRequestAsync(HttpMethod httpMethod, String uriPath, String uriQuery, String requetsBody, WebRequestTaskListener listener, int timeout) throws Exception {
        if (!initialized) {
            throw new Exception("Accessor not initialized");
        }
        RequestParameter parameter = new RequestParameter(generateUrl(), httpMethod, uriPath, uriQuery, requetsBody, true, listener);
        parameter.setTimeout(timeout);
        WebRequestTask requestTask = new WebRequestTask();
        requestTask.execute(parameter);
    }

    public static AccessorResponse runRequestSync(HttpMethod httpMethod, String uriPath, String uriQuery, String requetsBody) throws Exception {
        if (!initialized) {
            throw new Exception("Accessor not initialized");
        }
        RequestParameter parameter = new RequestParameter(generateUrl(), httpMethod, uriPath, uriQuery, requetsBody);
        WebRequestTask requestTask = new WebRequestTask();
        requestTask.execute(parameter);
        return requestTask.get();
    }

    public static String getServerUrl () {
        return generateUrl();
    }
}