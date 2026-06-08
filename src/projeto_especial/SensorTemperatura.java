package projeto_especial;

import java.util.Random;

/**
 * Classe que representa um sensor de temperatura.
 * Herda de ComponenteEspacial e implementa a interface Sensor.
 */
public class SensorTemperatura extends ComponenteEspacial implements Sensor {

    /**
     * Construtor da classe SensorTemperatura.
     * Inicializa o sensor com ID 1, nome "Sensor Temperatura" e temperatura 25°C.
     */
    public SensorTemperatura() {
        super(1, "Sensor Temperatura", 25);
    }

    /**
     * Lê o valor atual de temperatura medido pelo sensor.
     * @return Valor aleatório de temperatura entre 0 e 120 (simulação)
     */
    @Override
    public double lerValor() { return new Random().nextDouble() * 120; }

    /**
     * Verifica se o sensor de temperatura está funcionando corretamente.
     * @return true (sensor sempre funcionando nesta simulação)
     */
    @Override
    public boolean verificarFuncionamento() { return true; }

    /**
     * Retorna o tipo do sensor.
     * @return String "Temperatura"
     */
    @Override
    public String retornarTipo() { return "Temperatura"; }

    /**
     * Monitora o sensor de temperatura.
     * Exibe mensagem indicando que o monitoramento está em andamento.
     */
    @Override
    public void monitorar() {
        System.out.println("Monitorando temperatura...");
    }
}
