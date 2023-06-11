// precisamos buscar dados do endereço, vamos criar uma classe para representar o endereço
// criar uma classe com os dados do endereço que agente quer receber
// como eu só quero representar entao eu vou usar o record em vez da classe
// record: o record internamente por debaixo dos panos ele ja vai ter os geters, setrs e o toString

public record Endereco(String cep, String logradouro, String complemento,
                       String bairro, String localidade, String uf) {

    // crie uma nova classe chamada consultaCep para buscar o endereço pelo cep
}
