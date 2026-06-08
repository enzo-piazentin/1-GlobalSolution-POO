package projeto_especial;

/**
 * Classe que representa um Planeta.
 * Herda de CorpoCeleste e especializa comportamento para planetas.
 */
public class Planeta extends CorpoCeleste {

    private String composicao; // ex: "Rochoso", "Gasoso"

    /**
     * Construtor da classe Planeta.
     * @param id Identificador único
     * @param nome Nome do planeta
     * @param temperatura Temperatura em °C
     * @param distancia Distância em milhões de km
     * @param composicao Tipo de composição (Rochoso/Gasoso)
     * @param exploravel Se é explorável
     */
    public Planeta(int id, String nome, double temperatura, double distancia, String composicao, boolean exploravel) {
        super(id, nome, "Planeta", temperatura, distancia, exploravel);
        this.composicao = composicao;
    }

    public String getComposicao() { return composicao; }

    @Override
    public void monitorar() {
        System.out.println("Planeta '" + nome + "' (" + composicao + ") - Temp: " + temperatura + "°C | Status: " + (status ? "Ligado" : "Desligado"));
    }
}

