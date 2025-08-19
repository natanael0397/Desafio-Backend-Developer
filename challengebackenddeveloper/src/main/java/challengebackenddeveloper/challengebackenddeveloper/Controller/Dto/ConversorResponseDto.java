package challengebackenddeveloper.challengebackenddeveloper.Controller.Dto;


public record ConversorResponseDto(String code,
                                   String codein,
                                   String name,
                                   String high,
                                   String low,
                                   Double varBid,// não sei se está correto
                                   String pctChange,
                                   String bid,
                                   String timestamp,
                                   String create_date) {
}
