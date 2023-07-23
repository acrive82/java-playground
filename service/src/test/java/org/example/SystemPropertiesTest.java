package org.example;

import org.testng.annotations.Test;

import static junit.framework.Assert.assertNotNull;

public class SystemPropertiesTest {

    @Test
    public void checkTempFolder() {
        String tempFolder = System.getProperty("java.io.tmpdir");
        System.out.println("Temp folder: " + tempFolder);

        assertNotNull(tempFolder);

    }
}
