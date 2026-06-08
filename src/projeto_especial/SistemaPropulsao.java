package projeto_especial;

/**
 * Classe abstrata que representa um sistema de propulsão genérico.
 * Define o comportamento básico que todos os sistemas de propulsão devem implementar.
 */
public abstract class SistemaPropulsao {

    // Estado do motor (true = ligado, false = desligado)
    protected boolean ligado;
    // Potência atual do sistema em porcentagem (0-100)
    protected double potencia;

    // Liga o motor, alterando o estado para true
    public void ligarMotor() { ligado = true; }

    // Desliga o motor, alterando o estado para false
    public void desligarMotor() { ligado = false; }

    /**
     * Define a potência do sistema de propulsão com validação.
     * @param potencia Nova potência (deve estar entre 0 e 100)
     * @throws IllegalArgumentException se a potência estiver fora do intervalo válido
     */
    public void setPotencia(double potencia) {
        if (potencia < 0 || potencia > 100) {
            throw new IllegalArgumentException("Potência deve estar entre 0 e 100");
        }
        this.potencia = potencia;
    }

    // Retorna a potência atual
    public double getPotencia() { return potencia; }

    // Indica se o motor está ligado
    public boolean isLigado() { return ligado; }

    /**
     * Atalho para definir a potência e executar acelerar.
     * Permite acelerar fornecendo diretamente a porcentagem.
     */
    public void acelerar(double porcentagem) {
        setPotencia(porcentagem);
        acelerar();
    }

    /**
     * Método abstrato para acelerar o sistema de propulsão.
     * Cada tipo de propulsão deve implementar seu próprio comportamento de aceleração.
     */
    public abstract void acelerar();

    /**
     * Método abstrato para calcular o empuxo gerado pelo sistema.
     * Cada tipo de propulsão deve implementar sua própria fórmula de cálculo.
     * @return Valor do empuxo gerado
     */
    public abstract double calcularEmpuxo();
}

