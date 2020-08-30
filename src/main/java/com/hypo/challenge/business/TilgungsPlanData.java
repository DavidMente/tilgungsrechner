package com.hypo.challenge.business;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

abstract class TilgungsPlanData {
    protected Date datum;
    protected BigDecimal monatsRate;
    protected BigDecimal zinsen;
    protected BigDecimal tilgung;
    protected BigDecimal restSchuld;
    protected static DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

    protected TilgungsPlanData(Calendar cal) {
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
        this.datum = cal.getTime();
    }

    public BigDecimal getZinsen() {
        return zinsen;
    }

    public BigDecimal getTilgung() {
        return tilgung;
    }

    public BigDecimal getRestSchuld() {
        return restSchuld;
    }

    public BigDecimal getMonatsRate() {
        return monatsRate;
    }

    public String getDatum() {
        return formatter.format(datum);
    }
}
