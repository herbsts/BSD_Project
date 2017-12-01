package bsd.school2017.boost_it.pkgWebService;

/**
 * @author Martin on 23.11.2017.
 */

public final class AccessorResponse {
    private int code = -1;
    private String json = null;
    private Exception exception = null;

    public AccessorResponse() {
        super();
    }

    public AccessorResponse(int responseCode, String responseData) {
        super();
        code = responseCode;
        json = responseData;
    }

    protected void setCode (int code) {
        this.code = code;
    }

    protected void setJson (String json) {
        this.json = json;
    }

    protected void setException (Exception exception) {
        this.exception = exception;
    }

    public int getResponseCode () {
        return code;
    }

    public String getJson () {
        return json;
    }

    public Exception getException () {
        return exception;
    }
}