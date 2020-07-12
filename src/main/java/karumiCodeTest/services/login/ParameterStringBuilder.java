package karumiCodeTest.services.login;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * The ParameterStringBuilder class allows the application to generate a URL-encoded String with a set of
 * parameters given into a Map.
 */
public class ParameterStringBuilder {

    /**
     * @param params a set of parameters and it's values
     * @return an URL-encoded String with the parameters given
     * @throws UnsupportedEncodingException
     */
    public static String getParamsString(Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        //I did not use a beautiful lambda expression here because building a lambda which throws is not as clean as looping
        // using the EntrySet
        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }
}
