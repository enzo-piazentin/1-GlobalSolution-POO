package projeto_especial;

/**
 * Classe que representa um sistema de propulsão química.
 * Herda de SistemaPropulsao e implementa comportamento específico para propulsão química.
 */
public class PropulsaoQuimica extends SistemaPropulsao {

    // Quantidade de combustível consumido pelo sistema
    private double combustivelConsumido;

    /**
     * Construtor da classe PropulsaoQuimica.
     * @param combustivelConsumido Quantidade inicial de combustível consumido
     */
    public PropulsaoQuimica(double combustivelConsumido) {
        this.combustivelConsumido = combustivelConsumido;
    }

    /**
     * Acelera o sistema de propulsão química.
     * Exibe a potência atual em porcentagem.
     */
    @Override
    public void acelerar() {
        if (!ligado) {
            System.out.println("Motor químico está desligado. Ligando motor antes de acelerar...");
            super.ligarMotor();
        }
        System.out.println("Propulsão química acelerando em " + potencia + "%");
    }

    /**
     * Calcula o empuxo gerado pela propulsão química.
     * @return Empuxo calculado (potência multiplicada por 50)
     */
    @Override
    public double calcularEmpuxo() {
        return potencia * 50;
    }
}

