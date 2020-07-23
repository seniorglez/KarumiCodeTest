package org.seniorglez.karumiCodeTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.seniorglez.karumiCodeTest.persistence.PersistenceHelper;
import org.seniorglez.karumiCodeTest.persistence.PersistenceHelperDesktop;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPersistenceHelperDesktop {

    private PersistenceHelper persistenceHelper;

    @BeforeEach
    public void setUp() {
        persistenceHelper = new PersistenceHelperDesktop();
        persistenceHelper.setSessionToken("");
    }

    @Test
    public void shouldReturnNull() {
        assertTrue(null==persistenceHelper.getSessionToken());
    }

    @Test void shouldReturnToken() {
        persistenceHelper.setSessionToken("token1");
        assertTrue(persistenceHelper.getSessionToken()=="token1");
    }
}
