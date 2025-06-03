package br.com.alura.screenmatch.service.traducao;

import br.com.alura.screenmatch.service.ConsumoApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URLEncoder;

public class ConsultaMyMemory {

    private static final String ENDERECO = "https://api.mymemory.translated.net/get?q=";
    private static final String IDIOMA_ORIGEM = "&langpair=en|pt-br"; // Exemplo: traduzir de inglês para português

    public static String obterTraducao(String text) {
        ObjectMapper mapper = new ObjectMapper();

        ConsumoApi consumo = new ConsumoApi();

        String texto = URLEncoder.encode(text);
        String langpair = URLEncoder.encode("en|pt-br");

        String url = "https://api.mymemory.translated.net/get?q=" + texto + "&langpair=" + langpair;

        String json = consumo.obterDados(url);

        DadosTraducao traducao;
        try {
            traducao = mapper.readValue(json, DadosTraducao.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return traducao.dadosResposta().textoTraduzido();
    }
}