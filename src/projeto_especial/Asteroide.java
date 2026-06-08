package projeto_especial;

/**
 * Classe que representa um Asteroide.
 * Herda de CorpoCeleste com atributos específicos para rastreamento de colisão.
 */
public class Asteroide extends CorpoCeleste {

    private String statusRisco; // ex: "BEM", "ATENÇÃO", "CRÍTICO"
    private double velocidade; // velocidade em km/s

    /**
     * Construtor da classe Asteroide.
     * @param id Identificador único
     * @param nome Nome do asteroide
     * @param temperatura Temperatura em °C
     * @param distancia Distância em milhões de km
     * @param velocidade Velocidade em km/s
     * @param statusRisco Status de risco de colisão
     * @param exploravel Se é passível de exploração
     */
    public Asteroide(int id, String nome, double temperatura, double distancia, double velocidade, String statusRisco, boolean exploravel) {
        super(id, nome, "Asteroide", temperatura, distancia, exploravel);
        this.velocidade = velocidade;
        this.statusRisco = statusRisco;
    }

    public String getStatusRisco() { return statusRisco; }
    public double getVelocidade() { return velocidade; }

    public void setStatusRisco(String statusRisco) { this.statusRisco = statusRisco; }

    @Override
    public void monitorar() {
        System.out.println("Asteroide '" + nome + "' - Vel: " + velocidade + " km/s | Risco: " + statusRisco + " | Distância: " + getDistancia() + " milhões km");
    }
}

