package br.com.integracao.bridge;

public class FrotaPesadaFactory implements VeiculoFactory {

    public Veiculo criarVeiculo(Motor motor) {
        return new Caminhao(motor);
    }
}