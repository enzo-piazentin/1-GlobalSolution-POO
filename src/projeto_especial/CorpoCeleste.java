package projeto_especial;

/**
 * Classe abstrata que representa um corpo celeste genérico.
 * Serve como base para Planetas e Asteroides.
 */
public abstract class CorpoCeleste extends ComponenteEspacial {

    private String tipo; // ex: "Planeta", "Asteroide"
    private double distancia; // distância em millions de km
    private boolean exploravel;

    /**
     * Construtor da classe CorpoCeleste.
     * @param id Identificador único do corpo
     * @param nome Nome do corpo celeste
     * @param tipo Tipo (replicado para referencia)
     * @param temperatura Temperatura em °C
     * @param distancia Distância em milhões de km
     * @param exploravel Se é explorável
     */
    public CorpoCeleste(int id, String nome, String tipo, double temperatura, double distancia, boolean exploravel) {
        super(id, nome, temperatura);
        this.tipo = tipo;
        this.distancia = distancia;
        this.exploravel = exploravel;
    }

    public String getTipo() { return tipo; }
    public double getDistancia() { return distancia; }
    public boolean isExploravel() { return exploravel; }

    public void setExploravel(boolean exploravel) { this.exploravel = exploravel; }

    @Override
    public void monitorar() {
        System.out.println("Monitorando " + tipo + " '" + nome + "': distância=" + distancia + " milhões km");
    }
}

