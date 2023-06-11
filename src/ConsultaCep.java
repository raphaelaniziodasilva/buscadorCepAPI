import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {

    // vamos consumir uma api de endereço e retornar um endereço pelo cep
    public Endereco buscaEndereco(String cep) {

        // extraindo a URI: URL, vamos concatenar a URI com o cep que o usuario vai informar
        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json");

        //                          url          cep     json
        // uri: url = https://viacep.com.br/ws/01001000/json/

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // vamos utilizar o pacote lib Gson que baixamos e colocamos na pasta de dependencia
            // Gson serve para Transformar o JSON em objeto, vamos fazer a deserealização
            // pegar o json e transformar ele na classe que queremos ou seja a Endereco
            return new Gson().fromJson(response.body(), Endereco.class);
        } catch (Exception error) {
            throw new RuntimeException("Nao consegui obter o endereço a partir desse CEP");
        }

        // agora vamos fazer o teste e receber o endereço pelo cep, va para o arquivo main
    }
}
