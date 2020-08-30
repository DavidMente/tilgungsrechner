package com.hypo.challenge;

import com.hypo.challenge.business.TilgungsPlanAuszahlung;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Calendar;

public class TilgungsPlanAuszahlungTests {
    @Test
    void auszahlungWirdBerechnet() {
        BigDecimal darlehensbetrag = BigDecimal.valueOf(100000L);
        TilgungsPlanAuszahlung tilgungsPlanAuszahlung = new TilgungsPlanAuszahlung(Calendar.getInstance(), darlehensbetrag);

        Assertions.assertEquals(darlehensbetrag.negate(), tilgungsPlanAuszahlung.getMonatsRate());
        Assertions.assertEquals(darlehensbetrag.negate(), tilgungsPlanAuszahlung.getTilgung());
        Assertions.assertEquals(BigDecimal.ZERO, tilgungsPlanAuszahlung.getZinsen());
        Assertions.assertEquals(darlehensbetrag.negate(), tilgungsPlanAuszahlung.getMonatsRate());
    }
}
