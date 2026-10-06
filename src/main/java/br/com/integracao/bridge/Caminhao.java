package br.com.integracao.bridge;

public class Caminhao extends Veiculo {

    public Caminhao(Motor motor) {
        super(motor);
    }

    @Override
    public String descricao() {
        return "Caminhão";
    }
}