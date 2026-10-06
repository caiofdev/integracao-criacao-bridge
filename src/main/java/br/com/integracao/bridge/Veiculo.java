package br.com.integracao.bridge;

public abstract class Veiculo {

    private final Motor motor;

    protected Veiculo(Motor motor) {
        this.motor = motor;
    }

    public abstract String descricao();

    public String ligar() {
        return descricao() + ": " + motor.ligar();
    }
}