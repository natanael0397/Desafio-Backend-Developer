package challengebackenddeveloper.challengebackenddeveloper.Controller.Dto;

import challengebackenddeveloper.challengebackenddeveloper.Model.Conversor;
import lombok.Data;

@Data
public class TaxaCambioResponseDto {
    private Conversor usdBrl;
    private Conversor eurBrl;
    private Conversor btcBrl;
}
