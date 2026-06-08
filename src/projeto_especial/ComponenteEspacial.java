package projeto_especial;

/**
 * Classe abstrata que representa um componente espacial genérico.
 * Serve como base para todos os componentes do sistema espacial.
 */
public abstract class ComponenteEspacial {

    // Identificador único do componente
    protected int id;
    // Nome descritivo do componente
    protected String nome;
    // Estado atual do componente (true = ligado, false = desligado)
    protected boolean status;
    // Temperatura atual do componente em graus Celsius
    protected double temperatura;

    /**
     * Construtor da classe ComponenteEspacial.
     * @param id Identificador único do componente
     * @param nome Nome descritivo do componente
     * @param temperatura Temperatura inicial do componente
     */
    public ComponenteEspacial(int id, String nome, double temperatura) {
        this.id = id;
        this.nome = nome;
        this.temperatura = temperatura;
        this.status = false; // Componente inicia desligado
    }

    // Liga o componente, alterando o status para true
    public void ligar() {
        status = true;
    }

    // Desliga o componente, alterando o status para false
    public void desligar() {
        status = false;
    }

    // Metodo abstrato obrigatório para subclasses implementarem o monitoramento específico
    public abstract void monitorar();
}

