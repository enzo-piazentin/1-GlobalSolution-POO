package projeto_especial;

/**
 * Classe que armazena os dados da missão espacial.
 * Gerencia informações sensíveis como coordenadas, combustível e tripulação.
 */
public class DadosMissao {

    // Coordenadas geográficas da nave (informação sensível)
    private String coordenadas;
    // Código de acesso para verificar autorização
    private String codigoAcesso;
    // Nível de combustível atual em porcentagem
    private double combustivel;
    // Trajetória planejada da missão
    private String trajetoria;
    // Número de tripulantes a bordo
    private int tripulantes;

    /**
     * Construtor da classe DadosMissao.
     * @param coordenadas Coordenadas geográficas da nave
     * @param codigoAcesso Código para acesso a informações sensíveis
     * @param combustivel Nível inicial de combustível (0-100%)
     * @param trajetoria Trajetória planejada da missão
     * @param tripulantes Número de tripulantes
     */
    public DadosMissao(String coordenadas, String codigoAcesso,
                       double combustivel, String trajetoria, int tripulantes) {
        this.coordenadas = coordenadas;
        this.codigoAcesso = codigoAcesso;
        setCombustivel(combustivel); // Usa o setter para validar o valor (0-100)
        this.trajetoria = trajetoria;
        setTripulantes(tripulantes);
    }

    /**
     * Acessa as coordenadas da nave mediante autenticação.
     * @param senha Senha para verificar autorização
     * @return Coordenadas se a senha estiver correta, ou "Acesso negado"
     */
    public String acessarCoordenadas(String senha) {
        return codigoAcesso.equals(senha) ? coordenadas : "Acesso negado";
    }

    // Retorna o nível atual de combustível
    public double getCombustivel() {
        return combustivel;
    }

    /**
     * Define o nível de combustível com validação.
     * @param combustivel Novo nível de combustível (deve ser >= 0)
     * @throws IllegalArgumentException se o combustível for negativo
     */
    public void setCombustivel(double combustivel) {
        if (combustivel < 0 || combustivel > 100) throw new IllegalArgumentException("Combustível inválido (deve estar entre 0 e 100)");
        this.combustivel = combustivel;
        // Alerta se o combustível estiver abaixo do nível crítico (20%)
        if (combustivel < 20) {
            System.out.println("ALERTA: combustível abaixo de 20%");
        }
    }

    // Retorna a trajetória planejada da missão
    public String getTrajetoria() { return trajetoria; }
    
    // Retorna o número de tripulantes a bordo
    public int getTripulantes() { return tripulantes; }

    /**
     * Define o número de tripulantes com validação (não negativo).
     * @param tripulantes Número de tripulantes
     * @throws IllegalArgumentException se for negativo
     */
    public void setTripulantes(int tripulantes) {
        if (tripulantes < 0) throw new IllegalArgumentException("Número de tripulantes inválido");
        this.tripulantes = tripulantes;
    }
}

