package com.hypo.challenge;

import com.hypo.challenge.business.TilgungsPlanEintrag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Calendar;

public class TilgungsPlanEintragTests {

    private final TilgungsPlanEintrag tilgungsPlanEintrag = new TilgungsPlanEintrag(Calendar.getInstance(),
            BigDecimal.valueOf(343.33),
            BigDecimal.valueOf(-99833.34),
            BigDecimal.valueOf(2.12));

    @Test
    void zinsenWerdenBerechnet() {
        BigDecimal zinsen = tilgungsPlanEintrag.getZinsen();
        Assertions.assertEquals(BigDecimal.valueOf(176.37), zinsen);
    }

    @Test
    void tilgungWirdBerechnet() {
        BigDecimal tilgung = tilgungsPlanEintrag.getTilgung();
        Assertions.assertEquals(BigDecimal.valueOf(166.96), tilgung);
    }

    @Test
    void restSchuldWirdBerechnet() {
        BigDecimal restSchuld = tilgungsPlanEintrag.getRestSchuld();
        Assertions.assertEquals(BigDecimal.valueOf(-99666.38), restSchuld);
    }

}
