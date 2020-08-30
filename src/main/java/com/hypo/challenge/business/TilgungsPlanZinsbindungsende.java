package com.hypo.challenge.business;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public class TilgungsPlanZinsbindungsende extends TilgungsPlanData {
    public TilgungsPlanZinsbindungsende(Calendar datum, List<TilgungsPlanEintrag> tilgungsPlanEintraege) {
        super(datum);
        this.restSchuld = tilgungsPlanEintraege.get(tilgungsPlanEintraege.size() - 1).restSchuld;
        this.monatsRate = tilgungsPlanEintraege.stream().map(eintrag -> eintrag.monatsRate).reduce(BigDecimal::add).get();
        this.tilgung = tilgungsPlanEintraege.stream().map(eintrag -> eintrag.tilgung).reduce(BigDecimal::add).get();
        this.zinsen = tilgungsPlanEintraege.stream().map(eintrag -> eintrag.zinsen).reduce(BigDecimal::add).get();
    }
}
