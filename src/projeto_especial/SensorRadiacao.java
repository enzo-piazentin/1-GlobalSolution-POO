package projeto_especial;

import java.util.Random;

/**
 * Classe que representa um sensor de radiação.
 * Herda de ComponenteEspacial e implementa a interface Sensor.
 */
public class SensorRadiacao extends ComponenteEspacial implements Sensor {

    /**
     * Construtor da classe SensorRadiacao.
     * Inicializa o sensor com ID 3, nome "Sensor Radiacao" e temperatura 25°C.
     */
    public SensorRadiacao() {
        super(3, "Sensor Radiacao", 25);
    }

    /**
     * Lê o valor atual de radiação medido pelo sensor.
     * @return Valor aleatório de radiação entre 0 e 100 (simulação)
     */
    @Override
    public double lerValor() { return new Random().nextDouble() * 100; }

    /**
     * Verifica se o sensor de radiação está funcionando corretamente.
     * @return true (sensor sempre funcionando nesta simulação)
     */
    @Override
    public boolean verificarFuncionamento() { return true; }

    /**
     * Retorna o tipo do sensor.
     * @return String "Radiacao"
     */
    @Override
    public String retornarTipo() { return "Radiacao"; }

    /**
     * Monitora o sensor de radiação.
     * Exibe mensagem indicando que o monitoramento está em andamento.
     */
    @Override
    public void monitorar() {
        System.out.println("Monitorando radiacao...");
    }
}

