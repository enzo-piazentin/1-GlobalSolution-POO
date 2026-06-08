package projeto_especial;

/**
 * Interface que define o comportamento padrão de todos os sensores.
 * Todos os sensores do sistema devem implementar esta interface.
 */
public interface Sensor {

    /**
     * Lê o valor atual medido pelo sensor.
     * @return Valor medido pelo sensor
     */
    double lerValor();

    /**
     * Verifica se o sensor está funcionando corretamente.
     * @return true se o sensor estiver funcionando, false caso contrário
     */
    boolean verificarFuncionamento();

    /**
     * Retorna o tipo do sensor.
     * @return String descrevendo o tipo do sensor (ex: "Temperatura", "Pressão")
     */
    String retornarTipo();
}

