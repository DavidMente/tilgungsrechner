package com.hypo.challenge.business;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TilgungsPlan {

    private final TilgungsPlanAuszahlung auszahlung;
    private final List<TilgungsPlanEintrag> eintraege;
    private final TilgungsPlanZinsbindungsende zinsbindungsende;

    public TilgungsPlan(BigDecimal darlehensbetrag, BigDecimal sollzins, BigDecimal anfaenglicheTilgung, int zinsbindung) {
        BigDecimal monatsRate = calculateMonatsRate(darlehensbetrag, sollzins, anfaenglicheTilgung);
        Calendar cal = Calendar.getInstance();
        BigDecimal restSchuld = darlehensbetrag.negate();
        int months = zinsbindung * 12;

        this.auszahlung = new TilgungsPlanAuszahlung(cal, darlehensbetrag);

        List<TilgungsPlanEintrag> tilgungsPlanEintraege = new ArrayList<>();
        for (int month = 0; month < months; month++) {
            cal.add(Calendar.MONTH, +1);
            TilgungsPlanEintrag tilgungsPlanEintrag = new TilgungsPlanEintrag(cal, monatsRate, restSchuld, sollzins);
            restSchuld = tilgungsPlanEintrag.restSchuld;
            tilgungsPlanEintraege.add(tilgungsPlanEintrag);
        }
        this.eintraege = tilgungsPlanEintraege;

        this.zinsbindungsende = new TilgungsPlanZinsbindungsende(cal, tilgungsPlanEintraege);
    }

    public static BigDecimal calculateMonatsRate(BigDecimal darlehensbetrag, BigDecimal sollzins, BigDecimal anfaenglicheTilgung) {
        return darlehensbetrag.multiply(sollzins.add(anfaenglicheTilgung))
                .divide(BigDecimal.valueOf(100L), RoundingMode.HALF_UP)
                .divide(BigDecimal.valueOf(12L), RoundingMode.HALF_UP)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public List<TilgungsPlanEintrag> getEintraege() {
        return eintraege;
    }

    public TilgungsPlanAuszahlung getAuszahlung() {
        return auszahlung;
    }

    public TilgungsPlanZinsbindungsende getZinsbindungsende() {
        return zinsbindungsende;
    }
}
