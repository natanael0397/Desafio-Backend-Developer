package challengebackenddeveloper.challengebackenddeveloper.Client;

import challengebackenddeveloper.challengebackenddeveloper.Controller.Dto.ConversorResponseDto;
import challengebackenddeveloper.challengebackenddeveloper.Model.Conversor;
import challengebackenddeveloper.challengebackenddeveloper.Model.TaxaCambio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "https://economia.awesomeapi.com.br", name = "economia")
public interface ClientImport {

    @GetMapping("/json/last/{moedas}")
    public TaxaCambio retornaMoedasSelecionadas(@PathVariable("moedas") String moedas);

    @GetMapping("/json/daily/{moeda}/{numero_dias}")
    public List<Conversor> retornaFechamentoDosUltimosDias(@PathVariable("moeda") String moeda, @PathVariable("numero_dias") Integer numeroDias);


    @GetMapping("/{moeda}/{quantidade}")
    public List<Conversor> retornaCotacaoSequencialUnicaMoeda(@PathVariable("moeda")String moeda, @PathVariable("quantidade") Integer quantidade);

    @GetMapping("/{format}/{moeda}")
    public ConversorResponseDto formatoDeResposta(@PathVariable("format") String format, @PathVariable("moeda") String moeda);
}
