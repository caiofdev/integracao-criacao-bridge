package br.com.integracao.bridge;

public class MotorGasolina implements Motor {

    @Override
    public String ligar() {
        return "motor a gasolina ligado";
    }
}