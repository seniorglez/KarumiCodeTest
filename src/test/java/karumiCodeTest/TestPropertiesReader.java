package karumiCodeTest;

import karumiCodeTest.config.PropertiesReader;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPropertiesReader {

    /**
     *
     * https://regexr.com/37i6s
     */
    @Test
    public void shouldRetrieveAnURL() {
        PropertiesReader propertiesReader = PropertiesReader.instanciate();
        String url = propertiesReader.getProerty("url");
        Pattern pattern = Pattern.compile("https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,4}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)");
        Matcher matcher = pattern.matcher(url);
        assertTrue(matcher.matches());
    }
}
