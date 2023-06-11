import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // vamos criar o Scanner e solicitar o cep ou seja o usuario vai ter que informar o cep
        Scanner leitura = new Scanner(System.in);

        // instanciando o ConsultaCep para fazer a busca
        ConsultaCep consultaCep = new ConsultaCep();

        // usuario vai ter que informar o cep
        System.out.println("Digite o CEP para consulta: ");
        // a variavel cep: vai ler o cep que o usuario digitou, nextLine: vai entender que o cep é uma string
        var cep = leitura.nextLine();

        try {
            // buscando o endereço pelo cep
            Endereco novoEndereco = consultaCep.buscaEndereco(cep);
            System.out.println(novoEndereco);

            // Agora vamos criar o gerador que vai pegar o endereço passar para uma classe e essa classe vai gerar um arquivo no formato .json
            // crie uma classe chamada de GeradorDeArquivo

            // instanciando o gerador de arquivo
            GeradorDeArquivo geradorDeArquivoJson = new GeradorDeArquivo();
            geradorDeArquivoJson.gerarArquivoJson(novoEndereco);
        } catch (RuntimeException | IOException error) {
            System.out.println(error.getMessage());
            System.out.println("Finalizando a aplicaçao");
        }
    }
}