package br.com.integracao.bridge;

public class MotorDiesel implements Motor {

    @Override
    public String ligar() {
        return "motor a diesel ligado";
    }
}