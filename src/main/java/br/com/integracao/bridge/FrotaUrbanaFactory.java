package br.com.integracao.bridge;

public class FrotaUrbanaFactory implements VeiculoFactory {

    public Veiculo criarVeiculo(Motor motor) {
        return new Carro(motor);
    }
}