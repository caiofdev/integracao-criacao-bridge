package br.com.integracao.bridge;

public class FrotaEscolarService {

    /**
     * Registra um veículo na frota escolar, combinando:
     * - Singleton (Parametros): identifica quem está responsável pelo registro.
     * - Factory Method (MotorFactory): cria o Motor (implementador do Bridge) a partir
     *   de uma string, sem o chamador conhecer a classe concreta.
     * - Abstract Factory (VeiculoFactory): decide qual Veiculo (abstração do Bridge)
     *   deve ser montado para o tipo de frota.
     * - Bridge (Veiculo + Motor): o Veiculo criado recebe o Motor e os dois variam
     *   de forma independente — qualquer combinação veículo x motor funciona.
     */
    public RegistroVeiculo registrarVeiculo(String tipoFrota, String tipoMotor) {

        Parametros parametros = Parametros.getInstance();
        String responsavel = parametros.getUsuarioLogado();

        Motor motor = MotorFactory.obterMotor(tipoMotor);

        VeiculoFactory veiculoFactory = obterVeiculoFactory(tipoFrota);
        Veiculo veiculo = veiculoFactory.criarVeiculo(motor);

        String statusMotor = veiculo.ligar();

        return new RegistroVeiculo(veiculo.descricao(), statusMotor, responsavel);
    }

    private VeiculoFactory obterVeiculoFactory(String tipoFrota) {
        if ("Urbana".equalsIgnoreCase(tipoFrota)) {
            return new FrotaUrbanaFactory();
        }
        if ("Pesada".equalsIgnoreCase(tipoFrota)) {
            return new FrotaPesadaFactory();
        }
        throw new IllegalArgumentException("Tipo de frota inexistente");
    }
}