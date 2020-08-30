package com.hypo.challenge;

import com.hypo.challenge.business.TilgungsPlan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class TilgungsPlanTests {

    @Test
    void eintraegeWerdenErstellt() {
        TilgungsPlan tilgungsPlan = new TilgungsPlan(BigDecimal.valueOf(100000L), BigDecimal.valueOf(2.12), BigDecimal.valueOf(2L), 10);

        Assertions.assertEquals(120, tilgungsPlan.getEintraege().size());
    }

    @Test
    void monatsRateWirdBerechnet() {
        BigDecimal monatsRate = TilgungsPlan.calculateMonatsRate(BigDecimal.valueOf(100000L), BigDecimal.valueOf(2.12), BigDecimal.valueOf(2.0));

        Assertions.assertEquals(BigDecimal.valueOf(343.33), monatsRate);
    }

}
