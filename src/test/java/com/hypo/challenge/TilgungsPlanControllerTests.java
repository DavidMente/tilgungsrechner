package com.hypo.challenge;

import com.hypo.challenge.web.TilgungsPlanController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TilgungsPlanController.class)
public class TilgungsPlanControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void controllerShouldReturnTilgungsPlan() throws Exception {
        mvc.perform(get("/tilgungsplan")
                .param("darlehensbetrag", "100000")
                .param("sollzins", "2.12")
                .param("anfaenglicheTilgung", "2")
                .param("zinsbindung", "10"))
                .andExpect(status().isOk());
    }

}
