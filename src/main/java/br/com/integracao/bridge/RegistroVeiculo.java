package br.com.integracao.bridge;

public class RegistroVeiculo {

    private final String descricaoVeiculo;
    private final String statusMotor;
    private final String responsavel;

    public RegistroVeiculo(String descricaoVeiculo, String statusMotor, String responsavel) {
        this.descricaoVeiculo = descricaoVeiculo;
        this.statusMotor = statusMotor;
        this.responsavel = responsavel;
    }

    public String getDescricaoVeiculo() {
        return descricaoVeiculo;
    }

    public String getStatusMotor() {
        return statusMotor;
    }

    public String getResponsavel() {
        return responsavel;
    }
}