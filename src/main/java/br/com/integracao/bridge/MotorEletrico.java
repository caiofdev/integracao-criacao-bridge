package br.com.integracao.bridge;

public class MotorEletrico implements Motor {

    @Override
    public String ligar() {
        return "motor elétrico ligado";
    }
}