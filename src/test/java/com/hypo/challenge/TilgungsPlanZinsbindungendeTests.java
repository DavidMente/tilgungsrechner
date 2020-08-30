package com.hypo.challenge;

import com.hypo.challenge.business.TilgungsPlanEintrag;
import com.hypo.challenge.business.TilgungsPlanZinsbindungsende;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TilgungsPlanZinsbindungendeTests {
    @Test
    void gesamtwerteWerdenBerechnet() {

        List<TilgungsPlanEintrag> tilgungsPlanEintraege = new ArrayList<>();
        tilgungsPlanEintraege.add(new TilgungsPlanEintrag(Calendar.getInstance(),
                BigDecimal.valueOf(343.33),
                BigDecimal.valueOf(-99833.34),
                BigDecimal.valueOf(2.12))
        );
        tilgungsPlanEintraege.add(new TilgungsPlanEintrag(Calendar.getInstance(),
                BigDecimal.valueOf(343.33),
                BigDecimal.valueOf(-99666.38),
                BigDecimal.valueOf(2.12))
        );
        TilgungsPlanZinsbindungsende zinsbindungsende = new TilgungsPlanZinsbindungsende(Calendar.getInstance(), tilgungsPlanEintraege);

        Assertions.assertEquals(BigDecimal.valueOf(686.66), zinsbindungsende.getMonatsRate());
        Assertions.assertEquals(BigDecimal.valueOf(-99499.13), zinsbindungsende.getRestSchuld());
        Assertions.assertEquals(BigDecimal.valueOf(352.45), zinsbindungsende.getZinsen());
        Assertions.assertEquals(BigDecimal.valueOf(334.21), zinsbindungsende.getTilgung());
    }
}
