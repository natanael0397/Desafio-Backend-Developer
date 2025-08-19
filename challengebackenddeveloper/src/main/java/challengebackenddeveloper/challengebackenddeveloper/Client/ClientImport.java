package challengebackenddeveloper.challengebackenddeveloper.Client;

import challengebackenddeveloper.challengebackenddeveloper.Controller.Dto.ConversorResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Component
@FeignClient(url = "https://economia.awesomeapi.com.br/")
public interface ClientImport {

    @GetMapping("json/last/{moedas}")
    public ConversorResponseDto retornaMoedasSelecionadas(@PathVariable String moedas);

    @GetMapping("json/daily/{moeda}/{numero_dias}")
    public ConversorResponseDto retornaFechamentoDosUltimosDias(@PathVariable String moeda, Integer numero_dias);

    @GetMapping("json/daily/{moeda}/{numero_dias}?start_date=20180901&end_date=20180930")
    public  ConversorResponseDto retornaFechamentoPeriodoEspecifico(@PathVariable String moeda, Integer numero_dias);

    @GetMapping("/{moeda}/{quantidade}")
    public ConversorResponseDto retornaCotacaoSequencialUnicaMoeda(@PathVariable String moeda, Integer numero_dias);
    @GetMapping("{moeda}/{quantidade}?start_date=20200301&end_date=20200330")
    public ConversorResponseDto retornaCotacaoSequencialIntervaloDePeriodo1Minuto(@PathVariable String moeda, String quantidade);
    @GetMapping("{format}/{moeda}")
    public ConversorResponseDto formatoDeResposta(@PathVariable String format, String moeda);
}
