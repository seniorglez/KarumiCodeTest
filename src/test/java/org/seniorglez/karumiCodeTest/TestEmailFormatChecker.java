package org.seniorglez.karumiCodeTest;

import org.junit.jupiter.api.Test;
import org.seniorglez.karumiCodeTest.views.login.EmailFormatChecker;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestEmailFormatChecker implements EmailFormatChecker {

    @Test
    public void shouldReturnTrue() {
        assertTrue(checkEmail("seniorglez@yahoo.com"));
        assertTrue(checkEmail("seniorglez@karumi.com"));
        assertTrue(checkEmail("seniorglez@karumi.com.es"));
        assertTrue(checkEmail("seniorglez-diego@karumi.com"));
    }
}
