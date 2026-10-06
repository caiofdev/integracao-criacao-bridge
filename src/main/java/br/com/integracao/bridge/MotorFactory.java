package br.com.integracao.bridge;

public class MotorFactory {

    public static Motor obterMotor(String tipo) {
        try {
            Class<? extends Motor> classe = Class.forName(
                    "br.com.integracao.bridge.Motor" + tipo).asSubclass(Motor.class);
            return classe.getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException | ClassCastException ex) {
            throw new IllegalArgumentException("Tipo de motor inexistente");
        }
    }
}