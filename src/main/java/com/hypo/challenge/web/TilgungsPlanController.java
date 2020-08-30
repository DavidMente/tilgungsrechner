package com.hypo.challenge.web;

import com.hypo.challenge.business.TilgungsPlan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class TilgungsPlanController {

    @GetMapping("/tilgungsplan")
    public TilgungsPlan tilgungsPlan(
            @RequestParam("darlehensbetrag") BigDecimal darlehensbetrag,
            @RequestParam("sollzins") BigDecimal sollzins,
            @RequestParam("anfaenglicheTilgung") BigDecimal anfaenglicheTilgung,
            @RequestParam("zinsbindung") int zinsbindung
    ) {
        return new TilgungsPlan(darlehensbetrag, sollzins, anfaenglicheTilgung, zinsbindung);
    }
}
