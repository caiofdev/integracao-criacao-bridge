package br.com.integracao.bridge;

public class MotorHibrido implements Motor {

    @Override
    public String ligar() {
        return "motor híbrido ligado";
    }
}