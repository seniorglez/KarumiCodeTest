/* This file is part of KarumiCodeTest
 *
 *  Copyright (c) 2020 Diego Domínguez González
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 *  documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 *  rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 *  and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all copies or substantial portions
 *  of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 *  WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 *  OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 *  TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 *  IN THE SOFTWARE.
 */
package org.seniorglez.karumiCodeTest;
import org.junit.jupiter.api.Test;
import org.seniorglez.karumiCodeTest.views.login.EmailFormatChecker;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class TestEmailFormatChecker implements EmailFormatChecker {

    @Test
    public void testIfTheEmailsAreValidShouldReturnTrue() {
        assertTrue(checkEmail("seniorglez@yahoo.com"));
        assertTrue(checkEmail("seniorglez@karumi.com"));
        assertTrue(checkEmail("seniorglez@karumi.com.es"));
        assertTrue(checkEmail("seniorglez-diego@karumi.com"));
    }

    @Test
    public void testIfTheEmailsAreValidShouldReturnFalse() {
        assertTrue(!checkEmail("seniOrglez@yahoo.com"));
        assertTrue(!checkEmail("pepe*asda@yahoo.com"));
        assertTrue(!checkEmail("senior@yahoo.com.e"));
        assertTrue(!checkEmail("/asdasd@yahoo.com"));
        assertTrue(!checkEmail("asd;@yahoo.com"));
    }
}
