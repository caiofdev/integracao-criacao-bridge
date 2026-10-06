package br.com.integracao.bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrotaEscolarServiceTest {

    private final FrotaEscolarService service = new FrotaEscolarService();

    @BeforeEach
    public void configurarContextoGlobal() {
        Parametros.getInstance().setUsuarioLogado("Carlos Souza");
    }

    @Test
    public void deveRegistrarCarroUrbanoComMotorEletrico() {
        RegistroVeiculo registro = service.registrarVeiculo("Urbana", "Eletrico");

        assertEquals("Carro", registro.getDescricaoVeiculo());
        assertEquals("Carro: motor elétrico ligado", registro.getStatusMotor());
        assertEquals("Carlos Souza", registro.getResponsavel());
    }

    @Test
    public void deveRegistrarCaminhaoPesadoComMotorDiesel() {
        RegistroVeiculo registro = service.registrarVeiculo("Pesada", "Diesel");

        assertEquals("Caminhão", registro.getDescricaoVeiculo());
        assertEquals("Caminhão: motor a diesel ligado", registro.getStatusMotor());
    }

    @Test
    public void mesmaFrotaDeveAceitarMotoresDiferentesEmTempoDeExecucao() {
        // essência do Bridge mantida mesmo com a criação vindo de duas fábricas diferentes
        RegistroVeiculo comGasolina = service.registrarVeiculo("Urbana", "Gasolina");
        RegistroVeiculo comHibrido = service.registrarVeiculo("Urbana", "Hibrido");

        assertNotEquals(comGasolina.getStatusMotor(), comHibrido.getStatusMotor());
    }

    @Test
    public void deveLancarExcecaoParaTipoDeFrotaInexistente() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.registrarVeiculo("Aerea", "Eletrico")
        );
        assertEquals("Tipo de frota inexistente", ex.getMessage());
    }

    @Test
    public void deveLancarExcecaoParaTipoDeMotorInexistente() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.registrarVeiculo("Urbana", "Nuclear")
        );
        assertEquals("Tipo de motor inexistente", ex.getMessage());
    }
}