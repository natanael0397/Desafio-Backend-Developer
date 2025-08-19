package challengebackenddeveloper.challengebackenddeveloper.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxaCambio {
    @JsonProperty("USDBRL")
    private Conversor usdBrl;

    @JsonProperty("EURBRL")
    private Conversor eurBrl;

    @JsonProperty("BTCBRL")
    private Conversor btcBrl;
}
