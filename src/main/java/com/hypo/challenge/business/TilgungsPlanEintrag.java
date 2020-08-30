package com.hypo.challenge.business;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

public class TilgungsPlanEintrag extends TilgungsPlanData {
    public TilgungsPlanEintrag(Calendar datum, BigDecimal monatsRate, BigDecimal vorherigeRestschuld, BigDecimal sollzins) {
        super(datum);
        this.monatsRate = monatsRate;
        this.zinsen = vorherigeRestschuld.negate().multiply(sollzins).divide(BigDecimal.valueOf(1200L), RoundingMode.HALF_UP)
                .setScale(2, RoundingMode.HALF_UP);
        this.tilgung = monatsRate.subtract(zinsen);
        this.restSchuld = vorherigeRestschuld.add(tilgung);
    }
}
