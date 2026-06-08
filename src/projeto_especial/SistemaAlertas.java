package projeto_especial;

/**
 * Classe responsável por verificar valores de sensores e emitir alertas.
 */
public class SistemaAlertas {

    // Limites padrões para cada tipo de sensor
    private static final double LIMITE_TEMPERATURA = 80.0;
    private static final double LIMITE_PRESSAO = 150.0;
    private static final double LIMITE_RADIACAO = 70.0;

    public static void verificarSensores(Sensor... sensores) {
        for (Sensor s : sensores) {
            double valor = s.lerValor();
            String tipo = s.retornarTipo();
            double limite = pegarLimitePorTipo(tipo);

            String nivel = nivelAlerta(valor, limite);
            if (!nivel.equals("NORMAL")) {
                System.out.printf("ALERTA [%s] - Sensor %s: valor=%.2f limite=%.2f (%s)\n", nivel, tipo, valor, limite, s.verificarFuncionamento() ? "OK" : "FALHA");
            } else {
                System.out.printf("Sensor %s: valor=%.2f (OK)\n", tipo, valor);
            }
        }
    }

    private static double pegarLimitePorTipo(String tipo) {
        switch (tipo.toLowerCase()) {
            case "temperatura": return LIMITE_TEMPERATURA;
            case "pressao": return LIMITE_PRESSAO;
            case "radiacao": return LIMITE_RADIACAO;
            default: return Double.MAX_VALUE; // sem limite conhecido
        }
    }

    private static String nivelAlerta(double valor, double limite) {
        if (limite == Double.MAX_VALUE) return "NORMAL";
        if (valor >= limite * 1.5) return "CRÍTICO";
        if (valor >= limite * 1.2) return "ALERTA";
        if (valor >= limite) return "ATENÇÃO";
        return "NORMAL";
    }

    public static void verificarCombustivel(DadosMissao missao) {
        double c = missao.getCombustivel();
        if (c < 20) {
            System.out.println("ALERTA CRÍTICO: combustível abaixo de 20% — tomar medidas imediatas!");
        } else if (c < 35) {
            System.out.println("ALERTA: combustível baixo — considerar reabastecimento");
        } else {
            System.out.println("Combustível OK: " + c + "%");
        }
    }
}

