package challengebackenddeveloper.challengebackenddeveloper.Controller;

import challengebackenddeveloper.challengebackenddeveloper.Client.ClientImport;
import challengebackenddeveloper.challengebackenddeveloper.Controller.Dto.ConversorResponseDto;
import challengebackenddeveloper.challengebackenddeveloper.Controller.Dto.TaxaCambioResponseDto;
import challengebackenddeveloper.challengebackenddeveloper.Model.Conversor;
import challengebackenddeveloper.challengebackenddeveloper.Model.TaxaCambio;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/consuma")
public class ConversorController {
    @Autowired
    private ClientImport clientImport;
    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/atual/{moedas}")
    public ResponseEntity<TaxaCambioResponseDto> retornaMoedasSelecionadas(@PathVariable String moedas){
        TaxaCambio taxaCambio = clientImport.retornaMoedasSelecionadas(moedas);
        TaxaCambioResponseDto responseDto = modelMapper.map(taxaCambio,TaxaCambioResponseDto.class);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/moeda/recente/{moeda}/{numero_dias}")
    public ResponseEntity<List<ConversorResponseDto>> retornaFechamentoDosUltimosDias(@PathVariable String moeda, @PathVariable("numero_dias") Integer numeroDias){
            List<Conversor> conversores = clientImport.retornaFechamentoDosUltimosDias(moeda,numeroDias);
            Type listType = new TypeToken<List<ConversorResponseDto>>() {}.getType();
            List<ConversorResponseDto> conversorResponseDto = modelMapper.map(conversores, listType);
            return ResponseEntity.ok(conversorResponseDto);
    }

    @GetMapping("/cotacao/sequencial/{moeda}/{quantidade}")
    public ResponseEntity<List<ConversorResponseDto>> retornaCotacaoSequencialUnicaMoeda(@PathVariable String moeda,@PathVariable Integer quantidade){
        List<Conversor> conversores = clientImport.retornaCotacaoSequencialUnicaMoeda(moeda,quantidade);
        Type listType = new TypeToken<List<ConversorResponseDto>>() {}.getType();
        List<ConversorResponseDto> conversorResponseDto = modelMapper.map(conversores, listType);
        return ResponseEntity.ok(conversorResponseDto);
    }

    @GetMapping("/cotacao/sequencial1minuto/{moeda}/{quantidade}")
    public ResponseEntity<List<ConversorResponseDto>> retornaCotacaoSequencialIntervalo1Minuto(@PathVariable String moeda,@PathVariable Integer quantidade) {
        List<Conversor> conversores = clientImport.retornaFechamentoPeriodoEspecificoIntervalo1Min(moeda,quantidade);
        Type listType = new TypeToken<List<ConversorResponseDto>>() {}.getType();
        List<ConversorResponseDto> conversorResponseDto = modelMapper.map(conversores, listType);
        return ResponseEntity.ok(conversorResponseDto);
    }

    @GetMapping("/moeda/periodo/especifico/{moeda}/{numero_dias}")// ok
    public ResponseEntity<List<ConversorResponseDto>> retornaFechamentoPeriodoEspecifico(@PathVariable String moeda, @PathVariable("numero_dias") Integer numeroDias){
        List<Conversor> conversores = clientImport.retornaFechamentoPeriodoEspecifico(moeda,numeroDias);
        Type listType = new TypeToken<List<ConversorResponseDto>>() {}.getType();
        List<ConversorResponseDto> conversorResponseDto = modelMapper.map(conversores, listType);
        return ResponseEntity.ok(conversorResponseDto);
    }


}
