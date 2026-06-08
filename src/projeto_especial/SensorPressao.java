package projeto_especial;

import java.util.Random;

/**
 * Classe que representa um sensor de pressão.
 * Herda de ComponenteEspacial e implementa a interface Sensor.
 */
public class SensorPressao extends ComponenteEspacial implements Sensor {

    /**
     * Construtor da classe SensorPressao.
     * Inicializa o sensor com ID 2, nome "Sensor Pressao" e temperatura 25°C.
     */
    public SensorPressao() {
        super(2, "Sensor Pressao", 25);
    }

    /**
     * Lê o valor atual de pressão medido pelo sensor.
     * @return Valor aleatório de pressão entre 0 e 200 (simulação)
     */
    @Override
    public double lerValor() { return new Random().nextDouble() * 200; }

    /**
     * Verifica se o sensor de pressão está funcionando corretamente.
     * @return true (sensor sempre funcionando nesta simulação)
     */
    @Override
    public boolean verificarFuncionamento() { return true; }

    /**
     * Retorna o tipo do sensor.
     * @return String "Pressao"
     */
    @Override
    public String retornarTipo() { return "Pressao"; }

    /**
     * Monitora o sensor de pressão.
     * Exibe mensagem indicando que o monitoramento está em andamento.
     */
    @Override
    public void monitorar() {
        System.out.println("Monitorando pressao...");
    }
}

