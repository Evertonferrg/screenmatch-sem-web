package br.com.alura.screenmatch.service.traducao;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTraducao(
        @JsonAlias("responseData") DadosResposta dadosResposta, // Mapeia "responseData" para um objeto DadosResposta
        @JsonAlias("quotaFinished") Boolean quotaFinalizada,
        @JsonAlias("mtLangSupported") Object mtLangSuportado, // Pode ser String ou null, Object é mais flexível
        @JsonAlias("responseDetails") String detalhesResposta,
        @JsonAlias("responseStatus") Integer statusResposta,
        @JsonAlias("responderId") Object responderId, // Pode ser String ou null
        @JsonAlias("exception_code") Object codigoExcecao)
 {
}
