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

    @Test
    public void shouldReturnFalse(){
        assertTrue(!checkEmail("seniOrglez@yahoo.com"));
        assertTrue(!checkEmail("pepe*asda@yahoo.com"));
        assertTrue(!checkEmail("senior@yahoo.com.e"));
        assertTrue(!checkEmail("/asdasd@yahoo.com"));
        assertTrue(!checkEmail("asd;@yahoo.com"));
    }
}
