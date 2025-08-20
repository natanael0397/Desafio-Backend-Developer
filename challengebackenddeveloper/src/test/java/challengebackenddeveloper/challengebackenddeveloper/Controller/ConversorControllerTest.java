package challengebackenddeveloper.challengebackenddeveloper.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ConversorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveRetornarTaxaCambio() throws Exception {
        mockMvc.perform(get("/consuma/atual/USD-BRL"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.usdBrl").exists());
    }

    @Test
    void deveRetornarFechamentoDosUltimosDias() throws Exception {
        mockMvc.perform(get("/consuma/moeda/recente/USD/5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].code").exists());
    }

    @Test
    void deveRetornarCotacaoSequencial() throws Exception {
        mockMvc.perform(get("/consuma/cotacao/sequencial/USD/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].code").exists());
    }



}
