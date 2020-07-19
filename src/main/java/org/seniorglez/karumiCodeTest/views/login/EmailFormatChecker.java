package org.seniorglez.karumiCodeTest.views.login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface EmailFormatChecker {

    default boolean checkEmail(String email) {
        Pattern pattern = Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
