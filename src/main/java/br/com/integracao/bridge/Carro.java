package br.com.integracao.bridge;

public class Carro extends Veiculo {

    public Carro(Motor motor) {
        super(motor);
    }

    @Override
    public String descricao() {
        return "Carro";
    }
}