package net.jezhumble.demo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConversionJourneyTest {

    private SurveyDriver driver = new net.jezhumble.demo.SurveyDriver();

    @Test
    public void shouldConvertOneAcreFootToCubicMeters() {
        String cubicMeters = driver.convertToCubicMeters("1");
        assertEquals("1233", cubicMeters.substring(0, 4));
    }
}
