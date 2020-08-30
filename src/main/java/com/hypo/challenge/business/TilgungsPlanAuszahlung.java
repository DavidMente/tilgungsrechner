package com.hypo.challenge.business;

import java.math.BigDecimal;
import java.util.Calendar;

public class TilgungsPlanAuszahlung extends TilgungsPlanData {
    public TilgungsPlanAuszahlung(Calendar datum, BigDecimal darlehensbetrag) {
        super(datum);
        this.tilgung = darlehensbetrag.negate();
        this.monatsRate = darlehensbetrag.negate();
        this.restSchuld = darlehensbetrag.negate();
        this.zinsen = BigDecimal.ZERO;
    }
}
