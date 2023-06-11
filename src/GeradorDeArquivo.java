import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;

// Agora vamos criar o gerador que vai pegar o endereço passar para uma classe e essa classe vai gerar um arquivo no formato .json

public class GeradorDeArquivo {

    // o metodo gerador de arquivo vai ser do tipo void porque nao vai retornar nada vai só gerar o arquivo
    public void gerarArquivoJson(Endereco endereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter geradorDeArquivoJson = new FileWriter(endereco.cep() + ".json");
        geradorDeArquivoJson.write(gson.toJson(endereco));
        geradorDeArquivoJson.close();
    }

    // va para o arquivo main e gere o arquivo utilizando o metodo gerarArquivoJson
}
