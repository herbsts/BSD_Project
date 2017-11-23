package bsd.school2017.boost_it.pkgWebService;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * Created by Martin on 23.11.2017.
 */

public class StringEscape {
    public static String escapeString(String s) {
        String result = s.replace("\"", ":q:");
        result = StringEscapeUtils.escapeJava(result);
        result = result.replace("\\", "\\\\");
        return result.replace(":q:", "\"");
    }
    public static String unescapeString(String s) {
        return StringEscapeUtils.unescapeJava(s);
    }
}
