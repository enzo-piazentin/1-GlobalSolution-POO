package projeto_especial;

/**
 * Classe que representa um sistema de propulsão elétrica.
 * Herda de SistemaPropulsao e implementa comportamento específico para propulsão elétrica.
 */
public class PropulsaoEletrica extends SistemaPropulsao {

    // Quantidade de energia elétrica consumida pelo sistema
    private double energiaConsumida;

    /**
     * Construtor da classe PropulsaoEletrica.
     * @param energiaConsumida Quantidade inicial de energia consumida
     */
    public PropulsaoEletrica(double energiaConsumida) {
        this.energiaConsumida = energiaConsumida;
    }

    /**
     * Acelera o sistema de propulsão elétrica.
     * Exibe a potência atual em porcentagem.
     */
    @Override
    public void acelerar() {
        if (!ligado) {
            System.out.println("Motor elétrico está desligado. Ligando motor antes de acelerar...");
            super.ligarMotor();
        }
        System.out.println("Propulsão elétrica acelerando em " + potencia + "%");
    }

    /**
     * Calcula o empuxo gerado pela propulsão elétrica.
     * @return Empuxo calculado (potência multiplicada por 30)
     */
    @Override
    public double calcularEmpuxo() {
        return potencia * 30;
    }
}

